
public class gameBot {
    private int height;
    private int width;
    public int optimalX;
    public int optimalY;
    public EvaluateBoard evaluateBoard;
    static int[] DeffenderScore = new int[]{0, 1, 9, 81, 729};
    static int[] AttackScore = new int[]{0, 2, 18, 162, 1458};
    static int row,col, ePC, eHuman;


    public gameBot(int height, int width){
        this.height = height;
        this.width = width;
        evaluateBoard = new EvaluateBoard(height,width);
    }
    public void calculateEvaluateBoard(int player, int[][] status) {

        evaluateBoard.ResetBoard();


        for (row = 0; row < height; row++) { //Danh gia theo hang ngang
            for (col = 0; col < width - 4; col++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (status[row][col + i] == 1) {
                        eHuman++;
                    }
                    if (status[row][col + i] == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (status[row][col + i] == 0) {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    evaluateBoard.EBoard[row][col + i] += DeffenderScore[ePC];
                                } else {
                                    evaluateBoard.EBoard[row][col + i] += AttackScore[ePC];
                                }

                            } else if (ePC == 0) {
                                if (player == 2) {
                                    evaluateBoard.EBoard[row][col + i] += DeffenderScore[eHuman];
                                } else {
                                    evaluateBoard.EBoard[row][col + i] += DeffenderScore[eHuman];
                                }

                            }
                        }
                    }
                }
            }
        }

        for (col = 0; col < width; col++) { //Danh gia theo cot doc
            for (row = 0; row < height - 4; row++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (status[row + i][col] == 1) {
                        eHuman++;
                    }
                    if (status[row + i][col] == 2) {
                        ePC++;
                    }
                }
                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (status[row + i][col] == 0) // cộng điểm cho các ô chưa đánh
                        {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    evaluateBoard.EBoard[row + i][col] += DeffenderScore[ePC];
                                } else {
                                    evaluateBoard.EBoard[row + i][col] += AttackScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    evaluateBoard.EBoard[row + i][ col] += DeffenderScore[eHuman];
                                } else {
                                    evaluateBoard.EBoard[row + i][col] += AttackScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                evaluateBoard.EBoard[row + i][col] *= 2;
                            }
                        }
                    }

                }
            }
        }

        for (col = 0; col < width - 4; col++) { //duong cheo
            for (row = 0; row < height - 4; row++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (status[row + i][col + i] == 1) {
                        eHuman++;
                    }
                    if (status[row + i][col + i] == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (status[row + i][col + i] == 0) // Neu o chua duoc danh
                        {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    evaluateBoard.EBoard[row + i][col + i] += DeffenderScore[ePC];
                                } else {
                                    evaluateBoard.EBoard[row + i][col + i] += AttackScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    evaluateBoard.EBoard[row + i][col + i] += DeffenderScore[eHuman];
                                } else {
                                    evaluateBoard.EBoard[row + i][col + i] += AttackScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                evaluateBoard.EBoard[row + i][col + i] *= 2;
                            }
                        }
                    }

                }
            }
        }
        for (row = 4; row < width; row++) { //duong cheo
            for (col = 0; col < height - 4; col++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (status[row - i][col + i] == 1) {
                        eHuman++;
                    }
                    if (status[row - i][col + i] == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (status[row - i][col + i] == 0) // Neu o chua duoc danh
                        {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    evaluateBoard.EBoard[row - i][col + i] += DeffenderScore[ePC];
                                } else {
                                    evaluateBoard.EBoard[row - i][col + i] += AttackScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    evaluateBoard.EBoard[row - i][col + i] += DeffenderScore[eHuman];
                                } else {
                                    evaluateBoard.EBoard[row - i][ col + i] += AttackScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                evaluateBoard.EBoard[row - i][col + i] *= 2;
                            }
                        }
                    }

                }
            }
        }
    }
    public void FindBestMove(int[][] status){
        calculateEvaluateBoard(2, status);
        EvaluateBoard.Point temp = evaluateBoard.MaxPos();
        optimalX = temp.x;
        optimalY = temp.y;
    }

}
