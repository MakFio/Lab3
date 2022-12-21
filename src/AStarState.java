import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class AStarState
{

    private Map2D map;
    private HashMap <Location,Waypoint> open = new HashMap<>();
    private HashMap <Location, Waypoint> close = new HashMap<>();

    public AStarState(Map2D map)
    {
        if (map == null)
            throw new NullPointerException("map cannot be null");

        this.map = map;
    }

    public Map2D getMap()
    {
        return map;
    }

    public Waypoint getMinOpenWaypoint()
    {
        if (open.isEmpty()) return null;
        Collection<Waypoint> values = open.values();
        double min = Double.MAX_VALUE;
        Waypoint result = null;
        for (Waypoint w:values) {
            if (min > w.getTotalCost()) {
                min = w.getTotalCost();
                result = w;
            }
        }
        return result;
    }

    public boolean addOpenWaypoint(Waypoint newWP)
    {
        Location loc = newWP.getLocation();
        if (open.containsKey(loc)) {
            Waypoint w = open.get(loc);
            if (newWP.getPreviousCost()<w.getPreviousCost()) {
                open.put(loc,newWP);
                return true;
            }
            return false;
        }
        open.put(loc,newWP);
        return true;
    }


    public int numOpenWaypoints()
    {
        return open.size();
    }


    public void closeWaypoint(Location loc)
    {
        close.put (loc, open.get(loc));
        open.remove(loc);
    }

    public boolean isLocationClosed(Location loc)
    {
        if (close.containsKey(loc)) return true;
        else return false;
    }
}