/**
 * You have a cubic storeroom where the width, length,
 * and height of the room are all equal to n units.
 * You are asked to place n boxes in this room where each box is a cube of unit side length.
 * There are however some rules to placing the boxes:
 * You can place the boxes anywhere on the floor.
 * If box x is placed on top of the box y, then each side of the four vertical sides of the box y must either be adjacent to another box or to a wall.
 * Given an integer n, return the minimum possible number of boxes touching the floor.
 * Example:
 * Input: n = 3
 * Output: 3
 * Explanation: The figure above is for the placement of the three boxes.
 * These boxes are placed in the corner of the room, where the corner is on the left side.
 */

package _1739_building_boxes;

class Solution {
    public int minimumBoxes(int n) {
        int i = 1, j = 1, curNum = 1;
        while (curNum < n) { // 找到最大层数和最后一层的立方体个数
            n -= curNum;
            i++;
            curNum += i;
        }
        curNum = 1;
        while (curNum < n) { // 每多添加一个接触地面的盒子，可多放置 i + 1 个立方体
            n -= curNum;
            curNum++;
            j++;
        }
        return (i * (i - 1)) / 2 + j;
    }
}
