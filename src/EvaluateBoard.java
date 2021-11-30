public class EvaluateBoard {
    public int height;
    public int width;
    public int[][] EBoard;
    public int max;

    public  EvaluateBoard(int height,int width){
        this.height = height;
        this.width = width;
        EBoard = new int[height][width];
    }
    public class Point {
        int x ;
        int y ;

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
    public void ResetBoard(){
        for(int r = 0; r < height; r ++){
            for(int c = 0; c < width; c ++){
                EBoard[r][c] = 0 ;
            }
        }
    }
    public Point MaxPos(){
        max = 0;
        Point p = new Point();
        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                if(EBoard[r][c] > max){
                    p.x = r;
                    p.y = c;
                    max = EBoard[r][c];
                }
            }
        }
        return p;
    }

}
