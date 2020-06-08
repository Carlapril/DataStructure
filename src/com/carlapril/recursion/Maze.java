package com.carlapril.recursion;

/**
 * @author carlapril
 * @create 2020-06-08 20:44
 */
public class Maze {
    public static void main(String[] args) {
        int[][] maze = new int[8][8];//创建迷宫地图
        for (int i = 0; i < 8; i++) {//1表示墙壁
            maze[0][i] = 1;
            maze[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {//1表示墙壁
            maze[i][0] = 1;
            maze[i][7] = 1;
        }
        maze[2][1] = 1;
        maze[2][2] = 1;
        System.out.println("迷宫地图为：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();

        }
        boolean findWay = findWay(maze, 1, 1);
        System.out.println("findWay = " + findWay);
        System.out.println("迷宫地图出路为：");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(maze[i][j]);
            }
            System.out.println();

        }
    }

    /**
     * @param map 表示迷宫地图
     * @param i   表示迷宫的横竖坐标
     * @param j   表示迷宫的横竖坐标
     * @return 返回值表示是否走出迷宫
     */
    public static boolean findWay(int[][] map, int i, int j) {
        if (map[6][6] == 2) {
            return true;
        } else {
            if (map[i][j] == 0) {
                map[i][j] = 2;
                if (findWay(map, i+1,j )){//向下方走
                    return true;
                }else if(findWay(map,i,j+1)){//向右方走
                    return true;
                }else if(findWay(map,i-1,j)){//向上方走
                    return true;
                }else if (findWay(map,i,j-1)){//向左方走
                    return true;
                }else{
                    map[i][j]=3;
                    return false;
                }
            }else{//当地图上标有2，3，1时，返回false；
                return false;
            }
        }
    }

}
