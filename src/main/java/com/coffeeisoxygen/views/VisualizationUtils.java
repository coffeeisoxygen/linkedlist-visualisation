package com.coffeeisoxygen.views;

import java.awt.*;

public class VisualizationUtils {

    // Private constructor to hide the implicit public one
    private VisualizationUtils() {
        throw new UnsupportedOperationException("Utility class");
    }

    public static void drawArrowHead(Graphics2D g, int x1, int y1, int x2, int y2) {
        double angle = Math.atan2(y2 - y1, x2 - x1);
        int arrowHeadSize = 10;

        int xArrow1 = (int) (x2 - arrowHeadSize * Math.cos(angle - Math.PI / 6));
        int yArrow1 = (int) (y2 - arrowHeadSize * Math.sin(angle - Math.PI / 6));
        int xArrow2 = (int) (x2 - arrowHeadSize * Math.cos(angle + Math.PI / 6));
        int yArrow2 = (int) (y2 - arrowHeadSize * Math.sin(angle + Math.PI / 6));

        g.drawLine(x2, y2, xArrow1, yArrow1);
        g.drawLine(x2, y2, xArrow2, yArrow2);
    }
}
