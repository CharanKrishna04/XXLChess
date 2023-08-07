package XXLChess;

//import org.reflections.Reflections;
//import org.reflections.scanners.Scanners;

import XXLChess.Pieces.*;
import processing.core.PApplet;
import processing.core.PImage;
import processing.data.JSONObject;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import XXLChess.Pieces.*;

public class App extends PApplet {
    public static final int SPRITESIZE = 480;
    public static final int BlockSIZE = 48;
    public static final int SIDEBAR = 120;
    public static final int BOARD_WIDTH = 14;
    public static final int FPS = 120;
    public static PImage b_rook, b_knight, b_pawn, b_archbishop, b_bishop, b_camel, b_amazon, b_chancellor, b_knight_king, b_queen, b_king, w_rook, w_knight, w_pawn, w_archbishop, w_bishop, w_camel, w_amazon, w_chancellor, w_knight_king, w_queen, w_king;
    public static int WIDTH = BlockSIZE * BOARD_WIDTH + SIDEBAR;
    public static int HEIGHT = BOARD_WIDTH * BlockSIZE;
    private static int x = 5; //5
    private static int y = 5;//5
    public Block[][] board = new Block[14][14];
    public int Clock = 100 * FPS;
    public PieceColour turn;
    public String configPath;
    public int[][] last_move;
    public Block selected_Block;
    private boolean click;
    public Clock Clock_white, Clock_black;
    public Clock clockWhite;
    public Clock clockBlack;
    private WhiteAI whiteai;
    public boolean resigned;

    public App() {

        this.configPath = "config.json";
    }

    public static void main(String[] args) {
        PApplet.main("XXLChess.App");
    }

    /**
     * Initialise the setting of the window size.
     */
    public void settings() {

        size(WIDTH, HEIGHT);
    }

    /**
     * Load all resources such as images. Initialise the elements such as the player, enemies and map elements.
     */
    public void bringBoard(String file_name) {
        try {
            File f = new File(file_name);
            Scanner scan = new Scanner(f);
            for (int j = 0; j < BOARD_WIDTH; j++) {
                String line = scan.nextLine();
                for (int i = 0; i < line.length(); i++) {
                    char name = line.charAt(i);
                    switch (name) {
                        case 'P':
                            board[i][j].setPiece(new Pawn(PieceColour.black, b_pawn, i, j));
                            break;
                        case 'R':
                            this.board[i][j].setPiece(new Rook(PieceColour.black, b_rook, i, j));
                            break;
                        case 'N':
                            this.board[i][j].setPiece(new Knight(PieceColour.black, b_knight, i, j));
                            break;
                        case 'B':
                            this.board[i][j].setPiece(new Bishop(PieceColour.black, b_bishop, i, j));
                            break;
                        case 'H':
                            this.board[i][j].setPiece(new Archbishop(PieceColour.black, b_archbishop, i, j));
                            break;
                        case 'C':
                            this.board[i][j].setPiece(new Camel(PieceColour.black, b_camel, i, j));
                            break;
                        case 'G':
                            this.board[i][j].setPiece(new KnightKing(PieceColour.black, b_knight_king, i, j));
                            break;
                        case 'A':
                            this.board[i][j].setPiece(new Amazon(PieceColour.black, b_amazon, i, j));
                            break;
                        case 'K':
                            this.board[i][j].setPiece(new King(PieceColour.black, b_king, i, j));
                            break;
                        case 'E':
                            this.board[i][j].setPiece(new Chancellor(PieceColour.black, b_chancellor, i, j));
                            break;
                        case 'Q':
                            this.board[i][j].setPiece(new Queen(PieceColour.black, b_queen, i, j));
                            break;
                        case 'p':
                            board[i][j].setPiece(new Pawn(PieceColour.white, w_pawn, i, j));
                            break;
                        case 'r':
                            this.board[i][j].setPiece(new Rook(PieceColour.white, w_rook, i, j));
                            break;
                        case 'n':
                            this.board[i][j].setPiece(new Knight(PieceColour.white, w_knight, i, j));
                            break;
                        case 'b':
                            this.board[i][j].setPiece(new Bishop(PieceColour.white, w_bishop, i, j));
                            break;
                        case 'h':
                            this.board[i][j].setPiece(new Archbishop(PieceColour.white, w_archbishop, i, j));
                            break;
                        case 'c':
                            this.board[i][j].setPiece(new Camel(PieceColour.white, w_camel, i, j));
                            break;
                        case 'g':
                            this.board[i][j].setPiece(new KnightKing(PieceColour.white, w_knight_king, i, j));
                            break;
                        case 'a':
                            this.board[i][j].setPiece(new Amazon(PieceColour.white, w_amazon, i, j));
                            break;
                        case 'k':
                            this.board[i][j].setPiece(new King(PieceColour.white, w_king, i, j));
                            break;
                        case 'e':
                            this.board[i][j].setPiece(new Chancellor(PieceColour.white, w_chancellor, i, j));
                            break;
                        case 'q':
                            this.board[i][j].setPiece(new Queen(PieceColour.white, w_queen, i, j));
                            break;

                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setup() {
        frameRate(FPS);

        // Load images during setup

        b_pawn = loadImage("src/main/resources/XXLChess/b-pawn.png");
        b_rook = loadImage("src/main/resources/XXLChess/b-rook.png");
        b_knight = loadImage("src/main/resources/XXLChess/b-knight.png");
        b_bishop = loadImage("src/main/resources/XXLChess/b-bishop.png");
        b_knight_king = loadImage("src/main/resources/XXLChess/b-knight-king.png");
        b_queen = loadImage("src/main/resources/XXLChess/b-queen.png");
        b_archbishop = loadImage("src/main/resources/XXLChess/b-archbishop.png");
        b_camel = loadImage("src/main/resources/XXLChess/b-camel.png");
        b_amazon = loadImage("src/main/resources/XXLChess/b-amazon.png");
        b_king = loadImage("src/main/resources/XXLChess/b-king.png");
        b_chancellor = loadImage("src/main/resources/XXLChess/b-chancellor.png");

        w_pawn = loadImage("src/main/resources/XXLChess/w-pawn.png");
        w_rook = loadImage("src/main/resources/XXLChess/w-rook.png");
        w_knight = loadImage("src/main/resources/XXLChess/w-knight.png");
        w_bishop = loadImage("src/main/resources/XXLChess/w-bishop.png");
        w_knight_king = loadImage("src/main/resources/XXLChess/w-knight-king.png");
        w_queen = loadImage("src/main/resources/XXLChess/w-queen.png");
        w_archbishop = loadImage("src/main/resources/XXLChess/w-archbishop.png");
        w_camel = loadImage("src/main/resources/XXLChess/w-camel.png");
        w_amazon = loadImage("src/main/resources/XXLChess/w-amazon.png");
        w_king = loadImage("src/main/resources/XXLChess/w-king.png");
        w_chancellor = loadImage("src/main/resources/XXLChess/w-chancellor.png");


        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if ((i + j) % 2 == 0) this.board[i][j] = new Block(SelectedColour.LIGHT_BROWN);
                else this.board[i][j] = new Block(SelectedColour.DARK_BROWN);
            }
        }

        JSONObject conf = loadJSONObject(new File(this.configPath));
        String file_name = conf.getString("layout");

        int seconds_player = conf.getJSONObject("time_controls").getJSONObject("player").getInt("seconds");
        int increment_player = conf.getJSONObject("time_controls").getJSONObject("player").getInt("increment");

        int seconds_cpu = conf.getJSONObject("time_controls").getJSONObject("cpu").getInt("seconds");
        int increment_cpu = conf.getJSONObject("time_controls").getJSONObject("cpu").getInt("increment");

        PieceColour colour_of_player = ((conf.getString("player_colour") == "white") ? PieceColour.white : PieceColour.black);
        PieceColour colour_of_cpu = ((conf.getString("player_colour") == "white") ? PieceColour.black : PieceColour.white);

        if (colour_of_player == PieceColour.white) {
            Clock_white = new Clock(seconds_player / 60, seconds_player % 60, increment_player);
            Clock_black = new Clock(seconds_cpu / 60, seconds_cpu % 60, increment_cpu);
        }
        else {
            Clock_white = new Clock(seconds_cpu / 60, seconds_cpu % 60, increment_cpu);
            Clock_black = new Clock(seconds_player / 60, seconds_player % 60, increment_player);
        }

        turn = PieceColour.white;
        bringBoard(file_name);
        whiteai = new WhiteAI(this, colour_of_cpu);
        resigned = false;
        last_move = new int[][]{null, null};

    }

    /**
     * Receive key pressed signal from the keyboard.
     */

    @Override
    public void keyPressed(KeyEvent key) {

        if (key.getKey() == 'r') {
            setup();
        }
        if (key.getKey() == 'e') {
            resigned = true;
        }
    }

    public void keyReleased() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        x = e.getX() / BlockSIZE;
        y = e.getY() / BlockSIZE;
        click = true;
//        update_time(Clock_white,Clock_black,turn);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX() / BlockSIZE;
        y = e.getY() / BlockSIZE;
        click = true;

    }

    /**
     * Draw all elements in the game by current frame.
     */
    public void draw() {
        background(169, 169, 169);
        draw_board();
        textSize(20);
        fill(255, 255, 255);
        if (resigned) {
            text("Player Resigned!AI WON!", 120, 360);
            return;
        }
        update_time(Clock_white, Clock_black, turn);
        display_time(Clock_white, Clock_black, turn);
        if(Clock_black.getTime()<=0){
            System.out.println("Time:"+Clock_black.getTime());
//            Clock_black.start();
            Clock_black.finish();
            ChangeTurn();
        }  else if (Clock_white.getTime()<=0) {
//            Clock_white.start();
            Clock_white.finish();
            ChangeTurn();
        }
//        else if (isCheck()) {
//            fill(250, 0, 0);
//            text("Save your king!", 200, 360);
//            click = true;
//        }
        else if (isKingCheckMate(turn)) {
            fill(250, 0, 0);
            text("Checkmate", 200, 360);
        } else if (turn == whiteai.getColour()) {
            whiteai.move(this);
            ChangeTurn();
        } else {
            if (click) {
//                text(x + " " + y, 700, 360);
                if(x>=14&&y>=14){
                    click = true;
                }
                try{
                if (board[x][y].getPiece() != null
                        && board[x][y].getPiece().getColour() == turn) {
                    selected_Block = board[x][y];
                    reset_colour();
                    select_current_piece(x, y);
                    board[x][y].getPiece().select(this);
                }}
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }
                try {
                    if (board[x][y].getColour() == SelectedColour.LIGHT_BLUE || board[x][y].getColour() == SelectedColour.DARK_BLUE || board[x][y].getColour() == SelectedColour.ORANGE) {
                        selected_Block.getPiece().move(this, x, y);
                        last_move[0] = null;
                        last_move[1] = null;
                        reset_colour();
                        ChangeTurn();
                        selected_Block = null;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println(e);
                }
            }
            click = false;
        }

    }

    public PieceMoves getKing(Block[][] board, PieceColour colour) {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                PieceMoves piece = board[i][j].getPiece();
                if ((piece instanceof King) && (piece.getColour() == colour))
                    return board[i][j].getPiece();
            }
        }
        return null;
    }


    public double getPiecesMovementScore() {
        double score = 0;

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                PieceMoves piece = board[i][j].getPiece();
                if (piece != null && !(piece instanceof King)) {
                    double value = piece.getValue();
                    if (piece.getColour() == PieceColour.white) {
                        if (i >= 3 && i <= 10 && j >= 3 && j <= 10) {
                            score++;
                        }
                        score += value;
                    } else {
                        if (i >= 3 && i <= 10 && j >= 3 && j <= 10) {
                            score--;
                        }
                        score -= value;
                    }
                }
            }
        }
        if (isCheck(PieceColour.white)) {
            score -= 5;
        }
        if (isCheck(PieceColour.black)) {
            score += 5;
        }

        if (isKingCheckMate(PieceColour.white)) {
            score -= 10000;
        }
        if (isCheck(PieceColour.black)) {
            score += 10000;
        }
        return score;
    }

    public void update_time(Clock clock_white, Clock clock_black, PieceColour turn) {
        if (clock_black.getTime() <= 0 || clock_white.getTime() <= 0 || isKingCheckMate()) {
            clock_black.finish();
            clock_white.finish();
        } else if (turn == PieceColour.white) {
            System.out.println("Turn: " + turn);
            if (Clock_black.isRunning()) {
//                Clock_black.start();
                Clock_black.stop();
            }
            if (!Clock_white.isRunning()) {
//              Clock_white.stop();
              Clock_white.start();
            }
//            clock_white.reset();
            if (Clock_white.getTime() >3 * 60) {
                Clock_white.stop();
                Clock_white = new Clock(3, 0, Clock_white.getIncrement());
                Clock_white.start();
            }

        } else {
            System.out.println("Turn: " + turn);
            if (Clock_white.isRunning()) {
                Clock_white.stop();
            }
            if (!Clock_black.isRunning()) {
                Clock_black.start();
            }
//            clock_black.reset();
        }
    }

    public void display_time(Clock Clock_white, Clock Clock_black, PieceColour turn) {
        fill(255, 255, 255);
        long time_white = Clock_white.getTime();
        long time_black = Clock_black.getTime();
        String seconds = Long.toString(time_white % 60);
        if (time_white % 60 < 10) seconds = "0" + seconds;
        String time = time_white / 60 + ":" + seconds;
        text(time, 675, 600);
        seconds = Long.toString(time_black % 60);
        if (time_black % 60 < 10) seconds = "0" + seconds;
        time = time_black / 60 + ":" + seconds;
        text(time, 675, 100);
    }

    public PieceMoves getKing(PieceColour colour) {
        return getKing(this.board, colour);
    }

    public boolean isCheck(PieceColour turn) {
        PieceMoves king = getKing(board, turn);
        ArrayList<PieceMoves> opposite_pieces;
        if (turn == PieceColour.white) {
            opposite_pieces = getPieces(board, PieceColour.black);
        } else {
            opposite_pieces = getPieces(board, PieceColour.white);
        }
        int[] king_position = king.getPosition();
        for (PieceMoves piece : opposite_pieces) {
            ArrayList<int[]> moves = piece.getAvailableCaptures(this);
            for (int[] move : moves) {
                if (move[0] == king_position[0] && move[1] == king_position[1]) return true;
            }
        }
        return false;
    }

    public boolean isCheck() {
        return isCheck(turn);
    }

    public ArrayList<PieceMoves> getPieces(PieceColour colour) {
        return getPieces(this.board, colour);
    }

    public ArrayList<PieceMoves> getPieces(Block[][] board, PieceColour colour) {
        ArrayList<PieceMoves> pieces = new ArrayList<PieceMoves>();
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                if (board[i][j].getPiece() != null && board[i][j].getPiece().getColour() == colour) {
                    PieceMoves piece = board[i][j].getPiece();
                    pieces.add(piece);
                }
            }
        }
        return pieces;
    }

    public ArrayList<PieceMoves> getPiecesCheckmate() {
        ArrayList<PieceMoves> pieces;
        ArrayList<PieceMoves> result = new ArrayList<PieceMoves>();
        PieceMoves king = getKing(turn);
        int[] king_position = king.getPosition();
        if (turn == PieceColour.black)
            pieces = getPieces(PieceColour.white);
        else
            pieces = getPieces(PieceColour.black);
        for (PieceMoves piece : pieces) {
            ArrayList<int[]> moves = piece.getAvailableMoves(this);
            for (int[] move : moves) {
                if ((Math.abs(move[0] - king_position[0]) + Math.abs(move[1] - king_position[1]) <= 2) && (Math.abs(move[1] - king_position[1]) != 2) && (Math.abs(move[0] - king_position[0]) != 2)) {
                    result.add(piece);
                }
            }
        }
        return result;
    }

    public boolean isLegalMove(PieceMoves piece, int x1, int y1) {
        boolean legal = true;
        int[] position = piece.getPosition();
        Block original_Block = new Block(board[x1][y1].getColour(), board[x1][y1].getPiece());
        this.board[position[0]][position[1]].setPiece(null);
        this.board[x1][y1].setPiece(piece);
        piece.setPosition(x1, y1);
        if (isCheck(piece.getColour())) {
            legal = false;
        }
        this.board[position[0]][position[1]].setPiece(piece);
        this.board[x1][y1] = original_Block;
        piece.setPosition(position[0], position[1]);
        return legal;
    }

    public void reset_colour() {
        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                // if(board[i][j].getColour() != SelectedColour.YELLOW || board[i][j].getColour() != SelectedColour.RED){
                if ((i + j) % 2 == 0) this.board[i][j].setColour(SelectedColour.LIGHT_BROWN);
                else this.board[i][j].setColour(SelectedColour.DARK_BROWN);
                // }
            }
        }
    }

    public boolean isKingCheckMate(PieceColour turn) {
        ArrayList<PieceMoves> pieces = getPieces(turn);
        for (PieceMoves piece : pieces) {
            if (piece.getLegalMoves(this).size() > 0) {
                return false;
            }
        }
        return isCheck(turn);
    }
    public boolean isKingCheckMate() {
        return isKingCheckMate(turn);
    }

    public void draw_board() {
        if (last_move[0] != null && last_move[1] != null) {
            draw_move(last_move[0][0], last_move[0][1], last_move[1][0], last_move[1][1]);
        }

        if (isCheck()) {
            PieceMoves king = getKing(turn);
            int[] position = king.getPosition();
            if (board[position[0]][position[1]].getColour() == SelectedColour.LIGHT_BROWN ||
                    board[position[0]][position[1]].getColour() == SelectedColour.DARK_BROWN) {
                board[position[0]][position[1]].setColour(SelectedColour.RED);
            }
        }
        if (isKingCheckMate()) {
            ArrayList<PieceMoves> pieces = getPiecesCheckmate();
            for (PieceMoves piece : pieces) {
                int[] position = piece.getPosition();
                board[position[0]][position[1]].setColour(SelectedColour.RED);
            }
        }

        for (int i = 0; i < BOARD_WIDTH; i++) {
            for (int j = 0; j < BOARD_WIDTH; j++) {
                fill(this.board[i][j].getColour().R, this.board[i][j].getColour().G, this.board[i][j].getColour().B);
                this.rect(i * BlockSIZE, j * BlockSIZE, BlockSIZE, BlockSIZE);
                if (this.board[i][j].getPiece() != null) {
                    this.board[i][j].getPiece().draw(this);
                }
            }
        }

    }

    public void select_current_piece(int x, int y) {
        board[x][y].setColour(SelectedColour.GREEN);
    }

    public void select_free_Block(int x, int y) {
        if ((x + y) % 2 == 0) {
            board[x][y].setColour(SelectedColour.LIGHT_BLUE);
        } else {
            board[x][y].setColour(SelectedColour.DARK_BLUE);
        };
    }

    public void draw_move(int X, int Y, int x1, int y1) {
        if (board[X][Y].getColour() == SelectedColour.LIGHT_BROWN
                || board[X][Y].getColour() == SelectedColour.DARK_BROWN) {
            board[X][Y].setColour(SelectedColour.YELLOW);
        }
        if (board[x1][y1].getColour() == SelectedColour.LIGHT_BROWN
                || board[x1][y1].getColour() == SelectedColour.DARK_BROWN) {
            board[x1][y1].setColour(SelectedColour.YELLOW);
        }
    }


    public void select_blocked_Block(int x, int y) {

        board[x][y].setColour(SelectedColour.ORANGE);
    }

    public boolean captured(PieceMoves piece, int x, int y) {
        return y < BOARD_WIDTH && y >= 0 && x < BOARD_WIDTH && x >= 0 && board[x][y].getPiece() != null && board[x][y].getPiece().getColour() != piece.getColour();
    }

    public boolean Block_available(int x, int y) {
        return y < BOARD_WIDTH && y >= 0 && x < BOARD_WIDTH && x >= 0 && board[x][y].getPiece() == null;
    }

    public void ChangeTurn() {
        if (this.turn == PieceColour.white) this.turn = PieceColour.black;
        else this.turn = PieceColour.white;
    }

}
