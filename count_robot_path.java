

public static int robotPaths(int down, int right, String path)
{
    path = path+ down +","+ right +"  ";
    if(down==0 && right==0)
    {
        System.out.println(path);
        return 1;
    }

    int counter = 0;

    if(down==0)
        counter = robotPaths(down, right-1, path);
    else if(right==0)
        counter = robotPaths(down-1, right, path);
    else
        counter = robotPaths(down, right-1, path) + robotPaths(down-1, right, path);

    return counter;
}

public static void main(String[] args) 
{
    int N = 3;
    System.out.println("Total possible paths: "+robotPaths(N-1, N-1, ""));

}