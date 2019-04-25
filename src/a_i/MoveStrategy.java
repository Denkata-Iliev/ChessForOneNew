package a_i;

public interface MoveStrategy {

    long getNumBoardsEvaluated();

    Move execute(Board board);

}
