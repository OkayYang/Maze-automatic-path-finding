public class Task {

    /*
    0:为路
    1:为墙
    2:为起点
    3:为终点
     */
    private static int[][] grade_one={
            {1,1,1,1,1,1},
            {1,2,0,1,0,1},
            {1,1,0,0,0,1},
            {1,0,0,1,1,1},
            {1,1,0,0,3,1},
            {1,1,1,1,1,1},
    };
    private static int[][] grade_two={
            {1,1,1,1,1,1,1},
            {1,2,0,1,0,1,1},
            {1,1,0,0,0,0,1},
            {1,0,0,1,0,1,1},
            {1,1,0,0,1,1,1},
            {1,1,1,0,0,3,1},
            {1,1,1,1,1,1,1},
    };
    private static int [][] grade_three = {
            {1,1,1,1,1,1,1,1},
            {1,0,0,1,2,1,0,1},
            {1,1,0,0,0,0,0,1},
            {1,0,1,1,0,1,0,1},
            {1,1,3,0,1,0,0,1},
            {1,1,1,0,0,0,1,1},
            {1,1,1,1,1,1,1,1},
    };

    public static int[][] getGrade_one() {
        return grade_one;
    }

    public static int[][] getGrade_two() {
        return grade_two;
    }

    public static int[][] getGrade_three() {
        return grade_three;
    }
    public static int[][] getTask(int i){
        switch (i){
            case 1:return getGrade_one();
            case 2:return getGrade_two();
            case 3:return getGrade_three();

        }
        return getGrade_one();
    }
}
