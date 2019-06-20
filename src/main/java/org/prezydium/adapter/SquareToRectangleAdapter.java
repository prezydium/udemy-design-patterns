package org.prezydium.adapter;


import org.prezydium.adapter.model.Rectangle;
import org.prezydium.adapter.model.Square;

 public class SquareToRectangleAdapter implements Rectangle {

    private int width, height;

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public SquareToRectangleAdapter(Square square) {
        height = square.getSide();
        width = square.getSide();
    }
}
