package keywords;
import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	private TicTacToe model;
	
	public void startNewGame() {
		model = new TicTacToe();

	}
	
	public void markLocation(int row, int col) {
		model.setMark(row, col);

	}
	
	public String getMark(int row, int col) {
		TicTacToe.Mark m = model.getMark(row, col);
        if(m == TicTacToe.Mark.X) return "X";
        else if(m == TicTacToe.Mark.O) return "O";
        else return "";
		//return "";
	}
    
	public String getWinner() {
		TicTacToe.Result r = model.getResult();
        if(r == TicTacToe.Result.XWINS) return "X";
        else if(r == TicTacToe.Result.OWINS) return "O";
        else if(r == TicTacToe.Result.TIE) return "TIE";
		return "NONE";
		//return "";
	}
}
