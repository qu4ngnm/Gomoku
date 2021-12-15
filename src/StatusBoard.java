public class StatusBoard {
    int height;
    int width;
    int[][] statusBoard;
    StatusBoard(int height, int width){
        this.height = height;
        this.width = width;
        statusBoard = new int[height][width];
    }
    public void setStatus(int row, int col, int player){ //Khi ng choi danh vao o nao thi se thay doi trang thai o do
        statusBoard[row][col] = player;
    }
}
