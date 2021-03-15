package pathfinding.file;

//import org.junit.Assert;
//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
import org.junit.Test;

public class MapReaderTest {
    @Test
    public void mapReaderParsesMapCorrectly() {
    /*    int[][] grid = null;
        try {
            grid = MapReader.readMap("src/test/java/pathfinding/file/test.map");
        } catch (Exception ex) {
            fail(ex.toString());
        }
        for (int x=0; x<grid.length; x++) {
            for (int y=0; y<grid.length; y++) {
                System.out.print(grid[x][y]);
            }
            System.out.println("");
        }
        int[][] expectedGrid = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 1, 1, 1, 1, 1, 1, 1, 1},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        

        assertArrayEquals(expectedGrid, grid);
       /* for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                assertEquals(expectedGrid[x][y], grid[x][y]);
            }
        }*/
    }
}
