package com.myzmds.job.algorithm;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort {
    /**
     * @方法名称 bubbling
     * @功能描述 <pre>冒泡排序：将最大值 顶到最后</pre>
     * @param nums
     */
    public static void bubbling(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            // 每次少比较一次+下标
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j + 1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
    
    /**
     * @方法名称 choose
     * @功能描述 <pre>选择排序：找到最小值的索引，进行交换</pre>
     * @param nums
     */
    public static void choose(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
    }
    
    /**
     * @方法名称 insert
     * @功能描述 <pre>插入排序：基于顺序查找</pre>
     * @param nums
     */
    public static void insert(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0 && nums[j] < nums[j - 1]; j--) {
                int temp = nums[j];
                nums[j] = nums[j - 1];
                nums[j - 1] = temp;
            }
        }
    }
    
    /**
     * @方法名称 hill
     * @功能描述 <pre>希尔排序：基于逐趟缩小增量</pre>
     * @param nums
     */
    public static void hill(int[] nums) {
        if (null == nums || nums.length == 0) {
            return;
        }
        for (int gap = nums.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < nums.length; i++) {
                for (int j = i; j >= gap && nums[j] < nums[j - gap]; j = j - gap) {
                    int temp = nums[j];
                    nums[j] = nums[j - gap];
                    nums[j - gap] = temp;
                }
            }
        }
    }
    
    /**
     * @方法名称 halve
     * @功能描述 <pre>折半排序：基于折半查找</pre>
     * @param nums
     */
    public static void halve(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            int first = 0; // 第一次划分有序比较区间，比较区间的第一个元素所在位置为0
            int last = i - 1; // 第一次划分有序比较区间，比较区间的最后一个元素所在位置为n-1， 比较查找Array[i]合适插入的位置
            while (first <= last) {
                int middle = (first + last) / 2;// 中间值
                if (temp > nums[middle]) {
                    first = middle + 1;
                } else {
                    last = middle - 1;
                }
            }
            /* 确定好位置后，将位置之后的数据后移，插入待排序数据 */
            int j = i - 1;
            for (; j > last; j--) {
                nums[j + 1] = nums[j];
            }
            nums[j + 1] = temp;
        }
    }
    
    /**
     * @方法名称 merge
     * @功能描述 <pre>归并排序 ：将数组分为左，右两部分， 首先将数组分为左右两部分，分别进行归并排序， 然后合并左右两部分的排序结果就构成了一个有序数组</pre>
     * @param nums
     */
    public static void merge(int[] nums) {
        merge(nums, 0, nums.length - 1);
    }
    
    /**
     * @方法名称 merge
     * @功能描述 <pre>递归对数组进行归并排序</pre>
     * @param nums
     */
    private static void merge(int[] nums, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;
            // 对包括中点在内的左侧数组区间进行归并排序
            merge(nums, startIndex, mid);
            // 对中点之后的右侧数组区间进行归并排序
            merge(nums, mid + 1, endIndex);
            // 合并左和右两个独立的有序区间为一个有序区间
            join(nums, startIndex, mid, endIndex);
        }
    }
    
    /**
     * @方法名称 join
     * @功能描述 <pre>合并数组</pre>
     * @param nums
     * @param startIndex
     * @param midIndex
     * @param endIndex
     */
    private static void join(int[] nums, int startIndex, int midIndex, int endIndex) {
        int[] temp = new int[endIndex - startIndex + 1];
        int pr = 0;
        int p1 = startIndex;
        int p2 = midIndex + 1;
        while (p1 <= midIndex || p2 <= endIndex) {
            if (p1 == midIndex + 1) {
                while (p2 <= endIndex) {
                    temp[pr++] = nums[p2++];
                }
            } else if (p2 == endIndex + 1) {
                while (p1 <= midIndex) {
                    temp[pr++] = nums[p1++];
                }
            } else if (nums[p1] <= nums[p2]) {
                temp[pr++] = nums[p1++];
            } else {
                temp[pr++] = nums[p2++];
            }
        }
        for (p1 = startIndex, p2 = 0; p1 <= endIndex; p1++, p2++) {
            nums[p1] = temp[p2];
        }
    }
    
    /**
     * @方法名称 quick
     * @功能描述 <pre>快速排序</pre>
     * @param nums
     */
    public static void quick(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }
    
    /**
     * @方法名称 quick
     * @功能描述 <pre>选择数组中的一个元素作为标准，将所有比标准小的元素放到左边， 所有比标准大的元素放到右边。 并对左边和右边的元素做一样的快速排序过程。</pre>
     * @param nums
     * @param startIndex
     * @param endIndex
     */
    private static void quick(int[] nums, int startIndex, int endIndex) {
        int preIndex = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (nums[i] < nums[preIndex]) {
                int temp = nums[i];
                for (int j = i; j > preIndex; j--) {
                    nums[j] = nums[j - 1];
                }
                nums[preIndex] = temp;
                preIndex++;
            }
        }
        if (preIndex - startIndex > 1) {
            quick(nums, startIndex, preIndex - 1);
        }
        if (endIndex - preIndex > 1) {
            quick(nums, preIndex + 1, endIndex);
        }
    }
    
    public static void heap(int[] nums) {
        // 初始化无序数组为大顶堆
        for (int i = nums.length - 2; i >= 0; i--) {
            adjustHeap(nums, i, nums.length - 1);
        }
        // 将最大值元素交换至数组末端，并调整前端为大顶堆，循环直至前端只剩下一个元素
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i - 1);
        }
    }
    
    /**
     * 将除顶(不确定是否满足大顶堆条件)外，左子树和右子树都为一个堆的数组调整为大顶堆
     * 
     * @param nums 待调整数组
     * @param from 顶的指针
     * @param to 调整的末端(就是调整array[from]...array[to]这一段为一个大顶堆)
     */
    private static void adjustHeap(int[] nums, int from, int to) {
        int i = 0;
        // 比较节省比较次数的方法，只要比较到比其左右子树的根结点的值都大，就可以return了
        while (from + 2 * i + 2 <= to) {
            if (nums[from + i] < nums[from + 2 * i + 1] || nums[from + i] < nums[from + 2 * i + 2]) {
                if (nums[from + 2 * i + 1] > nums[from + 2 * i + 2]) {
                    swap(nums, from + i, from + 2 * i + 1);
                    i += i + 1;
                } else {
                    swap(nums, from + i, from + 2 * i + 2);
                    i += i + 2;
                }
            } else {
                return;
            }
        }
        if (from + 2 * i + 1 == to && nums[from + i] < nums[from + 2 * i + 1]) {
            // 有时会出现仅存在左子树的情况(左子树为调整数组的最后一个元素)
            swap(nums, from + i, from + 2 * i + 1);
        }
    }
    
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    
    /**
     * @方法名称 count
     * @功能描述 <pre>计数排序：每个桶只存储单一键值</pre>
     * @param nums
     * @return
     */
    public static int[] count(int[] nums) {
        if (nums.length == 0) {
            return nums;
        }
        // 找出最大值和最小值
        int min = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int[] bucket = new int[max - min + 1];
        Arrays.fill(bucket, 0);
        // 计数累加
        int bias = 0 - min;
        for (int i = 0; i < nums.length; i++) {
            bucket[nums[i] + bias]++;
        }
        // 反向填充
        int index = 0, i = 0;
        while (index < nums.length) {
            if (bucket[i] != 0) {
                nums[index] = i - bias;
                bucket[i]--;
                index++;
            } else
                i++;
        }
        return nums;
    }
    
    /**
     * @方法名称 bucket
     * @功能描述 <pre>桶排序：每个桶存储一定范围的数值</pre>
     * @param nums
     * @param bucketSize
     */
    public static ArrayList<Integer> bucket(ArrayList<Integer> array, int bucketSize) {
        if (array == null || array.size() < 2)
            return array;
        int max = array.get(0), min = array.get(0);
        // 找到最大值最小值
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) > max)
                max = array.get(i);
            if (array.get(i) < min)
                min = array.get(i);
        }
        int bucketCount = (max - min) / bucketSize + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketCount);
        ArrayList<Integer> resultArr = new ArrayList<>();
        for (int i = 0; i < bucketCount; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < array.size(); i++) {
            bucketArr.get((array.get(i) - min) / bucketSize).add(array.get(i));
        }
        for (int i = 0; i < bucketCount; i++) {
            if (bucketSize == 1) { // 如果带排序数组中有重复数字时 感谢 @见风任然是风 朋友指出错误
                for (int j = 0; j < bucketArr.get(i).size(); j++)
                    resultArr.add(bucketArr.get(i).get(j));
            } else {
                if (bucketCount == 1)
                    bucketSize--;
                ArrayList<Integer> temp = bucket(bucketArr.get(i), bucketSize);
                for (int j = 0; j < temp.size(); j++)
                    resultArr.add(temp.get(j));
            }
        }
        return resultArr;
    }
    
    /**
     * @方法名称 count
     * @功能描述 <pre>基数排序：根据键值的每位数字来分配桶</pre>
     * @param nums
     * @return
     */
    public static void radix(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        // 1.先算出最大数的位数；
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int maxDigit = 0;
        while (max != 0) {
            max /= 10;
            maxDigit++;
        }
        int mod = 10, div = 1;
        ArrayList<ArrayList<Integer>> bucketList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < 10; i++) {
            bucketList.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < maxDigit; i++, mod *= 10, div *= 10) {
            for (int j = 0; j < nums.length; j++) {
                int num = (nums[j] % mod) / div;
                bucketList.get(num).add(nums[j]);
            }
            int index = 0;
            for (int j = 0; j < bucketList.size(); j++) {
                for (int k = 0; k < bucketList.get(j).size(); k++) {
                    nums[index++] = bucketList.get(j).get(k);
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] nums = {1, 5, 5, 9, 0, 3, 8, 6, 2};
        radix(nums);
        System.out.println(Arrays.toString(nums));
    }
}
