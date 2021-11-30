
public class StatusBoard {
    int height;
    int width;
    int[][] statusBoard;
    int[][] saveBoard;
    StatusBoard(int height, int width){
        this.height = height;
        this.width = width;
        statusBoard = new int[height][width];
        saveBoard = new int[height][width];

    }

    public void initStatus(){ //Khoi tao trang thai cua tat ca cac o trong bang = 0
        for(int i = 0; i < height; i++){
            for(int j = 0; i < width; j++){
                statusBoard[i][j] = 0;
            }
        }
    }
    public void setStatus(int row, int col, int player){ //Khi ng choi danh vao o nao thi se thay doi trang thai o do
        statusBoard[row][col] = player;
    }

    public void saveStatus(){ //Tao 1 bang 2 de luu trang thai sau khi ng choi danh 1 nuoc
        for(int row = 0 ; row < height ; row++) {
            for(int col = 0 ; col < width ; col++) {
                saveBoard[row][col] = statusBoard[row][col] ;
            }
        }
    }

    public void loadStatus() {
        for(int row = 0 ; row < height ; row++) {
            for(int col = 0 ; col < width ; col++) {
                statusBoard[row][col] = saveBoard[row][col] ;
            }
        }
    }



}
