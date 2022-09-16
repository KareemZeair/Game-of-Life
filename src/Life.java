import java.awt.*;
import java.util.Arrays;
import java.util.Objects;

public class Life {

    private int iterations;
    public static int gridSize;
    private int pixelWidth = 20;
    private int[][] currentCells;
    private int[][] nextArray;

    private String pattern;
    private static Picture picture;

    private static Color white = new Color(255, 255, 255);
    private static Color black = new Color(0, 0, 0);


    private Life(int iterations, int gridSize, String pattern)
    {
        this.iterations = iterations;
        this.gridSize = gridSize;
        this.pattern = pattern;

        picture = new Picture(pixelWidth*gridSize, pixelWidth*gridSize);
        currentCells = new int[gridSize][gridSize];
        nextArray = new int[gridSize][gridSize];

    }

    private void drawCell(int i, int j, Color col)
    {
        for (int offsetX = 0; offsetX < pixelWidth; offsetX++)
        {
            for (int offsetY = 0; offsetY < pixelWidth; offsetY++)
            {
                // set() colours of an individual pixel
                picture.set((i*pixelWidth) + offsetX, (j*pixelWidth) + offsetY, col);
            }
        }

    }

    private int originCell(int gridSize)
    {
        return gridSize/2;
    }
    private void show()
    {
        picture.show();
    }

    private int[] findNeighbors(int v, int h, int gridSize)
    {
        int[] neighborsArray;
        int prevVert = v - 1;
        int nextVert = v + 1;
        int prevHorizon = h - 1;
        int nextHorizon = h + 1;

        if (v-1 < 0)
        {
            prevVert = gridSize-1;
        }
        if (v+1 == gridSize)
        {
           nextVert = 0;
        }
        if (h-1 < 0)
        {
            prevHorizon = gridSize-1;
        }
        if (h+1 == gridSize)
        {
            nextHorizon = 0;
        }

        neighborsArray = new int[]{currentCells[prevVert][nextHorizon], currentCells[prevVert][h], currentCells[prevVert][prevHorizon],
                                   currentCells[v][nextHorizon], currentCells[v][prevHorizon],
                                   currentCells[nextVert][nextHorizon], currentCells[nextVert][h], currentCells[nextVert][prevHorizon]};

        return neighborsArray;
    }

    public int numOfAliveNeighbors(int[] neighborsArray)
    {
        int alive = 0;
        for (int j = 0; j < neighborsArray.length; j++)
        {
            if (neighborsArray[j] == 1)
            {
                alive = alive+1;
            }
        }
        return alive;
    }

    private void judge(int v, int h) {
        int aliveNeighbors = numOfAliveNeighbors(findNeighbors(v, h, gridSize)); //in previous cells array
        if (currentCells[v][h] == 1 && aliveNeighbors < 2)
        {
            nextArray[v][h] = 0;
        }
        else if (currentCells[v][h] == 1 && aliveNeighbors > 3)
        {
            nextArray[v][h] = 0;
        }
        else if (currentCells[v][h] == 0 && aliveNeighbors == 3)
        {
            nextArray[v][h] = 1;
        }
        else
        {
            nextArray[v][h] = currentCells[v][h];
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int numIterations = Integer.parseInt(args[0]);
        int size = Integer.parseInt(args[1]);
        String p = args[2];

        Life life = new Life(numIterations, size, p);

        for (int i = 0; i < gridSize; i++)      //i is horizontal & j is vertical cell indexes technically
        {
            for (int j = 0; j < gridSize; j++)
            {
                life.drawCell(i, j, white);
            }
        }

        int origin = life.originCell(size);

        if (Objects.equals(p, "P"))
        {
            life.drawCell(origin, origin, black);
            life.currentCells[origin][origin] = 1;

            life.drawCell(origin+1, origin, black);
            life.currentCells[origin][origin+1] = 1;

            life.drawCell(origin+2, origin, black);
            life.currentCells[origin][origin+2] = 1;

            life.drawCell(origin-1, origin, black);
            life.currentCells[origin][origin-1] = 1;

            life.drawCell(origin-2, origin+1, black);
            life.currentCells[origin+1][origin-2] = 1;

            life.drawCell(origin-2, origin-1, black);
            life.currentCells[origin-1][origin-2] = 1;

            life.drawCell(origin+3, origin+1, black);
            life.currentCells[origin+1][origin+3] = 1;

            life.drawCell(origin+3, origin-1, black);
            life.currentCells[origin-1][origin+3] = 1;

            life.drawCell(origin+4, origin, black);
            life.currentCells[origin][origin+4] = 1;

            life.drawCell(origin+5, origin, black);
            life.currentCells[origin][origin+5] = 1;

            life.drawCell(origin-3, origin, black);
            life.currentCells[origin][origin-3] = 1;

            life.drawCell(origin-4, origin, black);
            life.currentCells[origin][origin-4] = 1;

        }
        else if (Objects.equals(p, "S"))
        {
            life.drawCell(origin+3, origin-3, black);
            life.currentCells[origin-3][origin+3] = 1;

            life.drawCell(origin+3, origin-4, black);
            life.currentCells[origin-4][origin+3] = 1;

            life.drawCell(origin+3, origin-5, black);
            life.currentCells[origin-5][origin+3] = 1;

            life.drawCell(origin+4, origin-5, black);
            life.currentCells[origin-5][origin+4] = 1;

            life.drawCell(origin+5, origin-5, black);
            life.currentCells[origin-5][origin+5] = 1;

            life.drawCell(origin+5, origin-6, black);
            life.currentCells[origin-6][origin+5] = 1;

            life.drawCell(origin+5, origin-4, black);
            life.currentCells[origin-4][origin+5] = 1;

            life.drawCell(origin-7, origin-6, black);
            life.currentCells[origin-6][origin-7] = 1;

            life.drawCell(origin-7, origin-7, black);
            life.currentCells[origin-7][origin-7] = 1;

            life.drawCell(origin-8, origin-6, black);
            life.currentCells[origin-6][origin-8] = 1;

            life.drawCell(origin-8, origin-7, black);
            life.currentCells[origin-7][origin-8] = 1;


            life.drawCell(origin-14, origin-6, black);
            life.currentCells[origin-6][origin-14] = 1;

            life.drawCell(origin-14, origin-7, black);
            life.currentCells[origin-7][origin-14] = 1;

            life.drawCell(origin-15, origin-6, black);
            life.currentCells[origin-6][origin-15] = 1;

            life.drawCell(origin-15, origin-7, black);
            life.currentCells[origin-7][origin-15] = 1;

            life.drawCell(origin-10, origin-2, black);
            life.currentCells[origin-2][origin-10] = 1;

            life.drawCell(origin-10, origin-3, black);
            life.currentCells[origin-3][origin-10] = 1;

            life.drawCell(origin-11, origin-2, black);
            life.currentCells[origin-2][origin-11] = 1;

            life.drawCell(origin-11, origin-3, black);
            life.currentCells[origin-3][origin-11] = 1;

            life.drawCell(origin+12, origin+1, black);
            life.currentCells[origin+1][origin+12] = 1;

            life.drawCell(origin+12, origin+2, black);
            life.currentCells[origin+2][origin+12] = 1;

            life.drawCell(origin+13, origin+1, black);
            life.currentCells[origin+1][origin+13] = 1;

            life.drawCell(origin+13, origin+2, black);
            life.currentCells[origin+2][origin+13] = 1;

            life.drawCell(origin+10, origin+5, black);
            life.currentCells[origin+5][origin+10] = 1;

            life.drawCell(origin+10, origin+4, black);
            life.currentCells[origin+4][origin+10] = 1;

            life.drawCell(origin+9, origin+5, black);
            life.currentCells[origin+5][origin+9] = 1;

            life.drawCell(origin+9, origin+4, black);
            life.currentCells[origin+4][origin+9] = 1;

            life.drawCell(origin+16, origin+5, black);
            life.currentCells[origin+5][origin+16] = 1;

            life.drawCell(origin+16, origin+4, black);
            life.currentCells[origin+4][origin+16] = 1;

            life.drawCell(origin+17, origin+5, black);
            life.currentCells[origin+5][origin+17] = 1;

            life.drawCell(origin+17, origin+4, black);
            life.currentCells[origin+4][origin+17] = 1;
        }
        else if (Objects.equals(p, "R"))
        {
            for (int i = 0; i < gridSize; i++)      //i is horizontal & j is vertical cell indexes technically
            {
                for (int j = 0; j < gridSize; j++)
                {
                    int x = (int) (Math.random() * 100);
                    if (x % 2 == 0)
                    {
                        life.drawCell(i, j, black);
                        life.currentCells[j][i] = 1;
                    }
                }
            }
        }

        life.show();

        for (int x = 0; x < numIterations; x++)
        {
            Thread.sleep(1000);
            System.out.println(Arrays.deepToString(life.currentCells));
            System.out.println("HONA SA2ASKOT QALEELAN------------");

            for (int i = 0; i < gridSize; i++)      //i is horizontal & j is vertical cell indexes technically
            {
                for (int j = 0; j < gridSize; j++)
                {
                    life.judge(i,j);

                    if (life.currentCells[i][j] == 0)
                    {
                        life.drawCell(j, i, white);
                    }
                    else
                    {
                        life.drawCell(j, i, black);
                    }

                }
            }
            life.currentCells = life.nextArray;
            life.show();
            life.nextArray = new int[gridSize][gridSize];
        }


    }


}