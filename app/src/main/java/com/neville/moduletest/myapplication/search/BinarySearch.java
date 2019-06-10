package com.neville.moduletest.myapplication.search;

/**
 * 二分法查找
 */

public class BinarySearch {
    public static void main(String[] args) {
//        int[] data = {0, 3, 4, 6, 7, 9, 24, 55, 66, 78, 93};
//        int index = binarySearch(55, data);
//        int index = binarySearchByRecursion(0, data.length, 55, data);

        int[] data = {0, 3, 4, 6, 7, 9, 9, 9, 24, 55, 66, 78, 93};
//        int index = binarySearchType1(9, data);
//        int index = binarySearchType2(9, data);
//        int index = binarySearchType3(8, data);
        int index = binarySearchType4(5, data);


        System.out.print(index);

    }

    //无重复数据
    private static int binarySearch(int searchData, int[] data) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);//优化，如果直接(left+right)/2 数值过大容易崩溃
            if (data[mid] == searchData) {
                return mid;
            } else if (data[mid] < searchData) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //递归实现
    private static int binarySearchByRecursion(int left, int right, int searchData, int[] data) {
        if (left > right) {
            return -1;
        }
        int mid = left + ((right - left) >> 1);
        if (data[mid] == searchData) {
            return mid;
        } else if (data[mid] < searchData) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
        return binarySearchByRecursion(left, right, searchData, data);
    }


    //查找第一个值等于给定值的元素
    private static int binarySearchType1(int searchData, int[] data) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - right) >> 1);
            if (data[mid] == searchData) {
                if (mid != 0 && data[mid - 1] == searchData) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else if (data[mid] < searchData) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    //查找最后一个值等于给定值的元素
    private static int binarySearchType2(int searchData, int[] data) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - right) >> 1);
            if (data[mid] == searchData) {
                if (mid != data.length - 1 && data[mid + 1] == searchData) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            } else if (data[mid] < searchData) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }


    //查找第一个大于等于给定值的元素
    private static int binarySearchType3(int searchData, int[] data) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - right) >> 1);
            if (data[mid] < searchData) {
                left = mid + 1;
            } else {
                if (mid != 0 && data[mid - 1] >= searchData) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

    //查找最后一个小于等于给定值的元素
    private static int binarySearchType4(int searchData, int[] data) {
        int left = 0, right = data.length - 1;
        while (left <= right) {
            int mid = left + ((right - right) >> 1);
            if (data[mid] > searchData) {
                right = mid - 1;
            } else {
                if (mid != data.length - 1 && data[mid + 1] <= searchData) {
                    left = mid + 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }

}
