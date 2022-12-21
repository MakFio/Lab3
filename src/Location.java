public class Location
{

    public int xCoord;

    public int yCoord;


    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }


    public Location()
    {
        this(0, 0);
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())  return false;
        if (!(o instanceof Location)) return false;
        Location loc = (Location) o;
        return loc.xCoord == xCoord && loc.yCoord == yCoord;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + xCoord;
        result = 31 * result + yCoord;
        return result;
    }
}