package edu.jsu.mcis;

public class TicTacToe {
	public enum Mark {EMPTY, X, O;
		public String representation() {
            String n = name().substring(0, 1);
            if("E".equals(n)) return "";
            else return n;
        }
		
	};
	private Mark[][] grid;
    private boolean playerTurn;	
    public enum Result {XWINS ("X wins"),OWINS ("O wins"),TIE ("It's a Tie"),NONE ("No contest");
		private String message;
        private Result(String s) { message = s; }
        public String message() {
            return message;
        }
	};
    
	
    public TicTacToe() {
        grid = new Mark[3][3];
		
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[row].length; col++) {
                grid[row][col] = Mark.EMPTY;
            }
        }
		
        playerTurn = true;
    }
    
	public Mark getMark(int row, int col) {
        return grid[row][col];
    }
	
    public boolean setMark(int row, int col){
        if(row >= 0 && row < grid.length && col >= 0 && col < grid[row].length) {
			
            if(grid[row][col] == Mark.EMPTY){
                grid[row][col] = (playerTurn)? Mark.X : Mark.O;
                playerTurn = !playerTurn;
                return true;
            }
			
            else return false;
        }
		
        else return false;
    }
    
    
    
    public boolean changeToX() {return playerTurn;}
    public boolean changeToO() {return !playerTurn;}
	
	private boolean allSpacesMarked(){
        for(int row = 0; row < grid.length; row++) {
			
            for(int col = 0; col < grid[row].length; col++) {
                if(grid[row][col] == Mark.EMPTY) {return false;}
            }
        }
		
        return true;
    }
    
    private Result getHorizontalResult(int row){
        if(grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2] && grid[row][0] != Mark.EMPTY){
			
            if(grid[row][0] == Mark.X) {return Result.XWINS;}
            else return Result.OWINS;
        }
		
        else return Result.NONE;
    }
    
    private Result getVerticalResult(int col) {
        if(grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col] && grid[0][col] != Mark.EMPTY){
			
            if(grid[0][col] == Mark.X) {return Result.XWINS;}
            else return Result.OWINS;
        }
		
        else return Result.NONE;        
    }
    
    
    
    public Result getResult() {
        Result result;
		
        for(int row = 0; row < grid.length; row++) {
            result = getHorizontalResult(row);
            if(result != Result.NONE) {return result;}
        }
		
        for(int col = 0; col < grid[0].length; col++) {
            result = getVerticalResult(col);
            if(result != Result.NONE) {return result;}
        }
		
        if(grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[0][0] != Mark.EMPTY) {
            if(grid[0][0] == Mark.X) {return Result.XWINS;}
            else return Result.OWINS;
        }
		
        if(grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[0][2] != Mark.EMPTY) {
            if(grid[0][2] == Mark.X) {return Result.XWINS;}
            else return Result.OWINS;
        }
		
        if(allSpacesMarked()) {return Result.TIE;}
        else return Result.NONE;
    }
    
	public String toString() {
        StringBuilder build = new StringBuilder();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                if(grid[i][j] == Mark.EMPTY) build.append(" ");
                else if(grid[i][j] == Mark.X) build.append("X");
                else build.append("O");
                if(j < 2) build.append("|");
            }
            if(i < 2) build.append("\n-----\n");
        }
        return build.toString();
    }
    
}
