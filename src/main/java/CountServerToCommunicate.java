public class CountServerToCommunicate {
    // bruteforce
        public int countServers(int[][] grid) {
            int numRows= grid.length;
            int numCols= numRows > 0 ? grid[0].length:0;
            int communicableServersCount = 0;

            // Traverse through the grid
            for(int row=0; row < numRows; ++row){
                for(int col=0; col < numCols; ++col){
                    if(grid[row][col] == 1){
                        boolean canCommunicate = false;
                        // Check for communication in the same row
                        for(int otherCol = 0; otherCol < numCols; ++otherCol) {
                            if(otherCol != col && grid[row][otherCol] == 1){
                                canCommunicate=true;
                                break;
                            }
                        }
                        // if a server was found in the same row, increment
                        //communicableServersCount
                        if (canCommunicate){
                            communicableServersCount++;
                        } else {
                            // Check for communication in the same column
                            for(int otherRow = 0; otherRow < numRows; ++otherRow){
                                if(otherRow != row && grid[otherRow][col] == 1){
                                    canCommunicate = true;
                                    break;
                                }
                            }
                            //If a server was found in the same column, increment
                            //communicableServersCount
                            if (canCommunicate){
                                communicableServersCount++;
                            }
                        }
                    }
                }

            }
            return communicableServersCount++;
        }

        //server grouping
            public int countServers2(int[][] grid) {
                int[] rowCounts= new int[grid[0].length];
                int[] lastServerInCol= new int[grid.length];
                int communicableServersCount = 0;
                for(int i=0; i<lastServerInCol.length; i++){
                    lastServerInCol[i]= -1;
                }

                //First pass to count servers in each row and column
                for(int row=0; row < grid.length; row++){
                    int serverCountInRow = 0;
                    for(int col=0; col < grid[0].length; col++){
                        if(grid[row][col] == 1){
                            serverCountInRow++;
                            rowCounts[col]++;
                            lastServerInCol[row] = col;
                        }
                    }
                    //If there is more than one server in the row, increase the count
                    if(serverCountInRow != 1){
                        communicableServersCount += serverCountInRow;
                        lastServerInCol[row] = -1;
                    }
                }

                // Second pass to check if servers can communicate
                for(int row = 0; row < grid.length; row++){
                    if(lastServerInCol[row] != -1 && rowCounts[lastServerInCol[row]] > 1){
                        communicableServersCount++;
                    }
                }
                return communicableServersCount++;
            }


}
