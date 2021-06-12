package cout.sngtech.gameoflife;

import java.awt.*;

public class Grid {

    public int[][] grid;
    public int[][] nextGrid;
    public final int rows, columns;
    public int cellSize = 10;

    // Based on Row and Col, not coordinates
    public int[][] neighbourOffsets = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public Grid(int rows, int columns, int cellSize) {
        this.rows = rows;
        this.columns = columns;
        this.grid = new int[rows][columns];
        this.cellSize = cellSize;

        this.nextGrid = Utils.copyOf(this.grid);
    }

    void tick() {
        setCellsNextGeneration();
    }

    void setCellsNextGeneration() {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                int aliveNeighbours = getSurroundingCellsAlive(i, j);
                // Alive cells remain alive when 2 or 3 neighbouring cells are alive
                if ((aliveNeighbours == 2 || aliveNeighbours == 3) && grid[i][j] == 1) {
                    nextGrid[i][j] = 1;
                    //System.out.println(1);
                }
                // Dead cells become alive when 3 neighbouring cells are alive
                else if(aliveNeighbours == 3 && grid[i][j] == 0) {
                    nextGrid[i][j] = 1;
                    //System.out.println(2);
                }
                // All other alive or dead cells become dead cells or stay as dead cells
                else {
                    nextGrid[i][j] = 0;
                    //System.out.println(3);
                }
            }
        }
        this.grid = Utils.copyOf(this.nextGrid);
    }

    int getSurroundingCellsAlive(int r, int c) {
        int aliveCount = 0;
        for(int[] xy : neighbourOffsets) {
            int row = r + xy[0];
            int col = c + xy[1];
            if (row >= 0 && row < rows) {
                if (col >= 0 && col < columns) {
                    if(grid[row][col] == 1) {
                        aliveCount++;
                    }
                }
            }
        }
        return aliveCount;
    }

    public void setInitialConfig() {
        //RANDOM CONFIG
        /*for(int i = 0; i < 50; i++) {
            int x = new Random().nextInt(rows);
            int y = new Random().nextInt(columns);

            grid[x][y] = 1;

            int x2 = new Random().nextInt(rows);
            int y2 = new Random().nextInt(columns);
            grid[x2][y2] = 1;
        }*/

        //MIDDLE SURROUND CELL CONFIG
        /*grid[0][0] = 1;
        grid[0][1] = 1;
        grid[0][2] = 1;
        grid[1][0] = 1;
        grid[1][1] = 1;
        grid[1][2] = 1;
        grid[2][0] = 1;
        grid[2][1] = 1;
        grid[2][2] = 1;*/

        //BLINKER CONFIG
        /*grid[1][1] = 1;
        grid[1][2] = 1;
        grid[1][3] = 1;*/

        //CIRCLE CONFIG (Algorithm to draw circle from StackOverFlow)
        /*int x1, y1;
        double i, angle;
        double r = 4;
        for(i = 0; i < 360; i += 0.1)
        {
            angle = i;
            x1 = (int) (r * Math.cos(angle * Math.PI / 180));
            y1 = (int) (r * Math.sin(angle * Math.PI / 180));
            grid[rows / 2 + x1][columns / 2 + y1] = 1;
        }*/

        //GLIDER CONFIG
        /*grid[1][3] = 1;
        grid[2][3] = 1;
        grid[3][3] = 1;
        grid[3][2] = 1;
        grid[2][1] = 1;*/

        //GOSPER GLIDER GUN
        grid[7][1] = 1;
        grid[7][2] = 1;
        grid[8][1] = 1;
        grid[8][2] = 1;

        grid[7][11] = 1;
        grid[8][11] = 1;
        grid[9][11] = 1;
        grid[6][12] = 1;
        grid[10][12] = 1;
        grid[5][13] = 1;
        grid[11][13] = 1;
        grid[5][14] = 1;
        grid[11][14] = 1;
        grid[8][15] = 1;
        grid[6][16] = 1;
        grid[10][16] = 1;
        grid[7][17] = 1;
        grid[8][17] = 1;
        grid[9][17] = 1;
        grid[8][18] = 1;

        grid[5][21] = 1;
        grid[6][21] = 1;
        grid[7][21] = 1;
        grid[5][22] = 1;
        grid[6][22] = 1;
        grid[7][22] = 1;
        grid[4][23] = 1;
        grid[8][23] = 1;
        grid[3][25] = 1;
        grid[4][25] = 1;
        grid[8][25] = 1;
        grid[9][25] = 1;

        grid[5][35] = 1;
        grid[6][35] = 1;
        grid[5][36] = 1;
        grid[6][36] = 1;
    }

    public void fillGrid(Graphics2D g) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                int index = grid[i][j];
                setCell(g, i, j, index);
            }
        }
    }

    public void drawWireFrame(Graphics2D g) {
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                g.setColor(Color.GRAY);
                g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }

    public void setCell(Graphics2D g, int x, int y, int index) {
        g.setColor(getColour(index));
        g.fillRect(y * cellSize, x * cellSize, cellSize, cellSize);
    }

    Color getColour(int index) {
        switch(index) {
            case 0:
                //Colour white if cell is dead
                return Color.WHITE;
            case 1:
                //Colour black if cell is alive
                return Color.BLACK;
        }
        //Colour red if there is an error
        return Color.RED;
    }
}
