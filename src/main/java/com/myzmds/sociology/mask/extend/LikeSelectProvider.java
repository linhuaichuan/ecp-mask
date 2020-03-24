package com.myzmds.sociology.mask.extend;

import java.util.Arrays;
import java.util.Set;

import org.apache.ibatis.mapping.MappedStatement;

import tk.mybatis.mapper.annotation.Version;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;
import tk.mybatis.mapper.mapperhelper.SqlHelper;

/**
 * @类名称 LikeSelectProvider.java
 * @类描述 <pre>模糊查询实现类</pre>
 * @作者  庄梦蝶殇 linhuaichuan1989@126.com
 * @创建时间 2019年3月21日 下午2:58:47
 * @版本 1.0.0
 *
 * @修改记录
 * <pre>
 *     版本                       修改人 		修改日期 		 修改内容描述
 *     ----------------------------------------------
 *     1.0.0 	       庄梦蝶殇 	2019年3月21日             
 *     ----------------------------------------------
 * </pre>
 */
public class LikeSelectProvider extends MapperTemplate {
    
    public LikeSelectProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }
    
    /**
     * @方法名称 selectLike
     * @功能描述 <pre>like查询</pre>
     * @param ms 映射语句对象
     * @return sql
     */
    public String selectLike(MappedStatement ms) {
        Class<?> entityClass = getEntityClass(ms);
        // 修改返回值类型为实体类型
        setResultType(ms, entityClass);
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.selectAllColumns(entityClass));
        sql.append(SqlHelper.fromTable(entityClass, tableName(entityClass)));
        sql.append(whereAllIfColumns(entityClass, true));
        sql.append(SqlHelper.orderByDefault(entityClass));
        return sql.toString();
    }
    
    /**
     * @方法名称 whereAllIfColumns
     * @功能描述 <pre>where所有列的条件，会判断是否!=null</pre>
     * @param entityClass 实体类
     * @param empty 是否判空
     * @return where语句
     */
    public static String whereAllIfColumns(Class<?> entityClass, boolean empty) {
        StringBuilder sql = new StringBuilder();
        boolean hasLogicDelete = false;
        
        sql.append("<where>");
        // 获取全部列
        Set<EntityColumn> columnSet = EntityHelper.getColumns(entityClass);
        EntityColumn logicDeleteColumn = SqlHelper.getLogicDeleteColumn(entityClass);
        LikeField likeFields = null;
        if (entityClass.isAnnotationPresent(LikeField.class)) {
            likeFields = entityClass.getAnnotation(LikeField.class);
            
        }
        // 当某个列有主键策略时，不需要考虑他的属性是否为空，因为如果为空，一定会根据主键策略给他生成一个值
        for (EntityColumn column : columnSet) {
            if (!column.getEntityField().isAnnotationPresent(Version.class)) {
                // 逻辑删除，后面拼接逻辑删除字段的未删除条件
                if (logicDeleteColumn != null && logicDeleteColumn == column) {
                    hasLogicDelete = true;
                    continue;
                }
                String columnCase = " AND " + column.getColumnEqualsHolder();
                if (null != likeFields && Arrays.asList(likeFields.fields()).contains(column.getEntityField().getName())) {
                    columnCase = " AND " + column.getColumn() + " like CONCAT(" + column.getColumnHolder() + ",'%')";
                }
                sql.append(SqlHelper.getIfNotNull(column, columnCase, empty));
            }
        }
        if (hasLogicDelete) {
            sql.append(SqlHelper.whereLogicDelete(entityClass, false));
        }
        
        sql.append("</where>");
        return sql.toString();
    }
}
