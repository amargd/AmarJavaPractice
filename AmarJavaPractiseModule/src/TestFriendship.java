      import org.junit.Test;

        import java.util.ArrayList;
        import java.util.List;

        import static org.junit.Assert.assertEquals;

public class TestFriendship {

    @Test
    public void testGetDirectFriends() {
        Friendship friendship = new Friendship();
        friendship.makeFriend("Aaron", "Bella");
        friendship.makeFriend("Bella", "Cindy");
        friendship.makeFriend("Bella", "David");
        friendship.makeFriend("David", "Elizabeth");
        friendship.makeFriend("Cindy", "Frank");

        List<String> directFriends = friendship.getDirectFriends("David");

        ArrayList<String> expectedFriends = new ArrayList<String>();
        expectedFriends.add("Bella");
        expectedFriends.add("Elizabeth");

        assertEquals(expectedFriends, directFriends);
    }

    @Test
    public void getIndirectFriends() {
        Friendship friendship = new Friendship();
        friendship.makeFriend("Aaron", "Bella");
        friendship.makeFriend("Bella", "Cindy");
        friendship.makeFriend("Bella", "David");
        friendship.makeFriend("David", "Elizabeth");
        friendship.makeFriend("Cindy", "Frank");

        List<String> directFriends = friendship.getIndirectFriends("David");

        ArrayList<String> expectedFriends = new ArrayList<String>();
        expectedFriends.add("Aaron");
        expectedFriends.add("Elizabeth");
        expectedFriends.add("Cindy");
        expectedFriends.add("Bella");

        assertEquals(expectedFriends, directFriends);
    }

    @Test
    public void removeFriends() {
        Friendship friendship = new Friendship();
        friendship.makeFriend("Aaron", "Bella");
        friendship.makeFriend("Aaron", "Elizabeth");
        friendship.makeFriend("Bella", "Cindy");
        friendship.makeFriend("Bella", "Aaron");

        //remove friends here
        friendship.unmakeFriend("Aaron", "Bella");

        ArrayList<String> expectedAaronDirectFriends = new ArrayList<String>();
        expectedAaronDirectFriends.add("Elizabeth");
        assertEquals(expectedAaronDirectFriends, friendship.getDirectFriends("Aaron"));

        ArrayList<String> expectedBellaDirectFriends = new ArrayList<String>();
        expectedBellaDirectFriends.add("Cindy");
        assertEquals(expectedBellaDirectFriends, friendship.getDirectFriends("Bella"));
    }

    @Test
    public void addFriendsFromTextFile()
    {
        Friendship friendship = new Friendship();
        String readFileString;
        List<String> namesList = null;
        if((readFileString = friendship.CreateFriends("C:\\Repositories\\AmarJavaPractice-GitHub\\AmarJavaPractiseModule\\src\\Friends.txt")) == null)
            try {
                throw new Exception("Friends file is empty!");
            } catch (Exception e) {
                e.printStackTrace();
            }

        for(String name: readFileString.split(";"))
            namesList.add(name);

        for(int i=0; i<namesList.size(); i+=2)
        {
            friendship.makeFriend(namesList.get(i), namesList.get(i+1));
        }

    }


}