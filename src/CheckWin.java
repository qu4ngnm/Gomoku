public class CheckWin {

    int height ;
    int width ;

    public CheckWin(int height, int width){
        this.height = height;
        this.width = width;
    }

    public boolean isHoa(int[][] status){
        for(int row = 0; row < height; row++){
            for(int col =0; col < width; col++){
                if(status[row][col] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean rowCheck(int row,int col,int[][] status, int player){ //ham se tu dong cong bien count them 1(count++) moi khi ng choi
        int count = 0;                                           //danh cung 1 hang, khi bien count >= 5 thi ng choi do win
        for(int i = 0; i < height; i++){
           if(status[row][i] == player){
               count++;
               if(count >= 5){
                   return true;
               }
           }
           else {
               count = 0;
           }
        }
        return false;
    }

    public boolean colCheck(int row,int col,int[][] status, int player){ //ham se tu dong cong bien count them 1(count++) moi khi ng choi
        int count = 0;                                           //danh cung 1 cot, khi bien count >= 5 thi ng choi do win
        for(int i = 0; i < height; i++){
            if(status[i][col] == player){
                count++;
                if(count >= 5){
                    return true;
                }
            }
            else{
                count = 0;
            }
        }
        return false;
    }

    public boolean cheoTraiCheck(int row,int col,int[][] status, int player){

        int count = 0;
        try {
            while (col > 0 && row > 0) {
                //Ham nay de check cac phan tu tren duong cheo len tren
                col--;
                row--;
            }
            while (col < width && row < height) {
                if (status[row][col] == player) {
                    count++;
                    if (count >= 5) {
                        return true;
                    }
                }
                else {
                    count = 0;
                }
                col++;
                row++;
            }
        } catch (Exception e) {
            System.out.println("Game got error!!");
        }
        return false;
    }
    public boolean cheoPhaiCheck(int row,int col,int[][] status, int player){

        int count = 0;
        try {
            //Check cac phan tu tren duong cheo xuong duoi
            while (col > 0 && row < 15) {
                col--;
                row++;
            }
            while (col <= 31 && row >= 0) {
                if (status[row][col] == player) {
                    count++;
                    if (count >= 5) {
                        return true;
                    }
                } else {
                    count = 0;
                }
                col++;
                row--;
            }

        } catch (Exception e) {
            System.out.println("Game got error!!");
        }
        return false;
    }
    public boolean isChecked(int row, int col, int[][] status, int player) {
        if (rowCheck(row, col, status, player)) {
            return true;
        }
        if (colCheck(row, col, status, player)) {
            return true;
        }
        if (cheoTraiCheck(row, col, status, player)) {
            return true;
        }
        if (cheoPhaiCheck(row, col, status, player)) {
            return true;
        }
        return false;
    }
}
