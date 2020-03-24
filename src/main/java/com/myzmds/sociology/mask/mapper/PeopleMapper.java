package com.myzmds.sociology.mask.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

import com.myzmds.sociology.mask.entity.People;

import tk.mybatis.mapper.additional.insert.InsertListMapper;
import tk.mybatis.mapper.common.BaseMapper;

public interface PeopleMapper extends BaseMapper<People>, InsertListMapper<People> {
    @Select("select shouji, shenfenzheng, LEFT(riqi,10) as riqi from yuyue where riqi > #{date} ")
    public List<Map<String, String>> getHistory(String date);
}
