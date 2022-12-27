/**
 * If we were to write this representation in code, it will look like this:
 * "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext".
 * Note that the '\n' and '\t' are the new-line and tab characters.
 * Every file and directory has a unique absolute path in the file system,
 * which is the order of directories that must be opened to reach the file/directory itself,
 * all concatenated by '/'s. Using the above example, the absolute path to file2.ext is "dir/subdir2/subsubdir2/file2.ext".
 * Each directory name consists of letters, digits, and/or spaces.
 * Each file name is of the form name.extension, where name and extension consist of letters, digits, and/or spaces.
 * Given a string input representing the file system in the explained format,
 * return the length of the longest absolute path to a file in the abstracted file system.
 * If there is no file in the system, return 0.
 * Note that the testcases are generated such that the file system is valid and no file or directory name has length 0.
 * Example:
 * Input: input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * Output: 20
 * Explanation: We have only one file, and the absolute path is "dir/subdir2/file.ext" of length 20.
 */
package _0388_longest_absolute_file_path;

class Solution {
    /* 动态规划 */
    public int lengthLongestPath(String input) {
        String[] words = input.split("\t");
        int[] pathLens = new int[input.length() + 1];
        int longestPath = 0;
        pathLens[0] = -1; // 层级从 1 开始
        for (String word : words) {
            int level = word.lastIndexOf('\t') + 2; // 记录层级
            int fileLen = word.length() - level + 1; // 文件实际长度
            pathLens[level] = pathLens[level - 1] + fileLen + 1; // 路径长度，1 表示 '/'
            if (word.contains(".")) { // 为文件
                longestPath = Math.max(longestPath, pathLens[level]);
            }
        }
        return longestPath;
    }
}
