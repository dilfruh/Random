package dil.random;

import android.media.MediaPlayer;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    TextView text3;
    TextView text4;
    TextView text5;
    TextView text6;
    TextView text7;
    TextView text8;
    Button fortuneButton;
    Button kartButton;
    Button strikersButton;
    Button smashButton;
    Button golfButton;
    Button partyButton;
    Button gameButton;
    MediaPlayer shulkBack;
    MediaPlayer shulkFeel;
    MediaPlayer shulkKill;
    MediaPlayer shulkTime;
    MediaPlayer wal;
    MediaPlayer war;
    MediaPlayer car;
    MediaPlayer bow;
    MediaPlayer dai;
    MediaPlayer dk;
    MediaPlayer mar;
    MediaPlayer pea;
    MediaPlayer linky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up buttons
        fortuneButton = (Button) findViewById(R.id.fortuneButton);
        kartButton = (Button) findViewById(R.id.kartButton);
        strikersButton = (Button) findViewById(R.id.strikersButton);
        smashButton = (Button) findViewById(R.id.smashButton);
        golfButton = (Button) findViewById(R.id.golfButton);
        partyButton = (Button) findViewById(R.id.partyButton);
        gameButton = (Button) findViewById(R.id.gameButton);

        // Set up text to display results
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        text5 = (TextView) findViewById(R.id.text5);
        text6 = (TextView) findViewById(R.id.text6);
        text7 = (TextView) findViewById(R.id.text7);
        text8 = (TextView) findViewById(R.id.text8);

        // Set up sounds
        shulkBack = MediaPlayer.create(this, R.raw.backslash);
        shulkFeel = MediaPlayer.create(this, R.raw.feeling_it);
        shulkKill = MediaPlayer.create(this, R.raw.kill_you);
        shulkTime = MediaPlayer.create(this, R.raw.shulk_time);
        wal = MediaPlayer.create(this, R.raw.waluigi);
        war = MediaPlayer.create(this, R.raw.wario);
        car = MediaPlayer.create(this, R.raw.carver);
        bow = MediaPlayer.create(this, R.raw.bowser);
        dai = MediaPlayer.create(this, R.raw.daisy);
        dk = MediaPlayer.create(this, R.raw.donkey_kong);
        mar = MediaPlayer.create(this, R.raw.mario);
        pea = MediaPlayer.create(this, R.raw.peach);
        linky = MediaPlayer.create(this, R.raw.link);

        // Play shulk sound on launch
        stopMediaPlayers();
        getShulk().start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will automatically handle clicks on the Home/Up button, so long as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.shulky) {
            // If shulk is clicked on app bar
            stopMediaPlayers();
            getShulk().start();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // HELPERS

    /**
     *
     * @param min
     * @param max
     * @return random int between min and max, inclusive of both
     */
    private int getRandomInt(int min, int max) {
        Random rand = new Random();
        return (rand.nextInt(max - min + 1) + min);
    }

    /**
     *
     * @param arr any array
     * @return
     * @param <T> a random index (int) of the array
     */
    private <T> int getRandomIndex(T[] arr) {
        return getRandomInt(0, arr.length - 1);
    }

    /**
     * Format name and index so that user can easily see what and where it is. Ex: Randomly chose Waluigi who is the first character to choose from. Call getDisplayString('Waluigi', 0) because first index is 0 to return 'Waluigi (1)'
     * @param name
     * @param index
     * @return combined string
     */
    private String getDisplayString(String name, int index) {
        return name+" ("+(index+1)+")";
    }

    // SOUNDS

    /**
     *
     * @return One of 4 MediaPlayer sounds for shulk
     */
    private MediaPlayer getShulk() {
        // Get one of the shulk sounds
        MediaPlayer[] shulks = {shulkBack, shulkFeel, shulkKill, shulkTime};
        int index = getRandomInt(0, shulks.length-1);
        return shulks[index];
    }

    /**
     *
     * @param name name of the character whose sound you want to play. Ex: 'Waluigi'
     * @return MediaPlayer sound for that character
     */
    private MediaPlayer getSound(String name) {
        if (name=="Waluigi") return wal;
        else if (name=="Wario") return war;
        else if (name=="Carver") return car;
        else if (name=="Bowser") return bow;
        else if (name=="Daisy") return dai;
        else if (name=="Donkey Kong") return dk;
        else if (name=="Mario") return mar;
        else if (name=="Peach") return pea;
        else if (name=="Link") return linky;
        else if (name=="Shulk") return getShulk();
        else return null;
    }

    /**
     * Play up to 4 sounds at once for characters. Plays them in order. Input null for the ones you don't have.
     * @param s1 1st character name. Ex: 'Waluigi'
     * @param s2 2nd character name. Ex: 'Waluigi'
     * @param s3 3rd character name. Ex: 'Waluigi'
     * @param s4 4th character name. Ex: 'Waluigi'
     */
    private void playSounds(String s1, String s2, String s3, String s4) {
        // TODO: could make them input as many as they want. This just felt clearer to use at first
        MediaPlayer m1 = getSound(s1);
        MediaPlayer m2 = getSound(s2);
        MediaPlayer m3 = getSound(s3);
        MediaPlayer m4 = getSound(s4);
        ArrayList<MediaPlayer> players = new ArrayList<MediaPlayer>();
        if (m1!=null) players.add(m1);
        if (m2!=null) players.add(m2);
        if (m3!=null) players.add(m3);
        if (m4!=null) players.add(m4);

        // For each sound, play the next one after it's done
        for (int i = 0; i < players.size(); i++) {
            if (i!=players.size()-1) {
                MediaPlayer next = players.get(i+1);
                players.get(i).setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    boolean playedOnce = false; // This just prevents an infinite loop if we have two of the same sounds in the list
                    @Override
                    public void onCompletion(MediaPlayer m) {
                        if (!playedOnce) next.start();
                        playedOnce = true;
                    }
                });
            }
        }
        if (!players.isEmpty()) players.get(0).start();
    }

    /**
     * Stop playing all sounds. Usually want to call this before playSounds
     */
    private void stopMediaPlayers() {
        MediaPlayer[] sounds = {shulkBack, shulkFeel, shulkKill, shulkTime, wal, war, car, bow, dai, dk, mar, pea, linky};
        for (MediaPlayer sound : sounds) {
            try {
                sound.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer m) {
                    }
                });
                sound.stop();
                sound.prepare();
            } catch (Exception e) {}
        }
    }

    // BUTTONS

    /**
     * Get random characters and kart setup for Mario Kart 8 Deluxe
     * @param view
     */
    public void kartClicked(View view) {
        stopMediaPlayers();

        String[] characters = {"Mario", "Luigi", "Peach", "Daisy", "Rosalina", "Tanooki Mario", "Cat Peach", "Yoshi", "Toad", "Koopa Troopa", "Shy Guy", "Lakitu", "Toadette", "King Boo", "Baby Mario", "Baby Luigi", "Baby Peach", "Baby Daisy", "Baby Rosalina", "Gold/Metal Mario", "Pink Gold Peach", "Wario", "Waluigi", "Donkey Kong", "Bowser", "Dry Bones", "Bowser Jr.", "Dry Bowser", "Lemmy", "Larry", "Wendy", "Ludwig", "Iggy", "Roy", "Morton", "Inkling Girl", "Inkling Boy", "Link", "Male Villager", "Female Villager", "Isabelle", "Mii!!!"};
        int character1Index = getRandomIndex(characters);
        String character1Name = characters[character1Index];
        int character2Index = getRandomIndex(characters);
        // No duplicate characters
        while (character2Index == character1Index){
            character2Index = getRandomIndex(characters);
        }
        String character2Name = characters[character2Index];

        String[] karts = {"Standard Kart", "Pipe Frame", "Mach 8", "Steel Driver", "Cat Cruiser", "Circuit Special", "Tri-Speeder", "Badwagon", "Prancer", "Biddybuggy", "Landship", "Sneeker", "Sports Coupe", "Gold Standard", "GLA", "W 25 Silver Arrow", "300 SL Roadster", "Blue Falcon", "Tanooki Kart", "B Dasher", "Streetle", "P-Wing", "Koopa Clown", "Standard Bike", "Comet", "Sport Bike", "The Duke", "Flame Rider", "Varmint", "Mr. Scooty", "Jet Bike", "Yoshi Bike", "Master Cycle", "Master Cycle Zero", "City Tripper", "Standard ATV", "Wild Wiggler", "Teddy Buggy", "Bone Rattler", "Splat Buggy", "Inkstriker"};
        int kart1Index = getRandomIndex(karts);
        String kart1Name = karts[kart1Index];
        int kart2Index = getRandomIndex(karts);
        String kart2Name = karts[kart2Index];

        String[] tires = {"Standard", "Monster", "Roller", "Slim", "Slick", "Metal", "Button", "Off-Road", "Sponge", "Wood", "Cushion", "Blue Standard", "Hot Monster", "Azure Roller", "Crimson Slim", "Cyber Slick", "Retro Off-Road", "Gold Tires", "GLA Tires", "Triforce Tires", "Ancient Tires", "Leaf Tires"};
        int tires1Index = getRandomIndex(tires);
        String tires1Name = tires[tires1Index];
        int tires2Index = getRandomIndex(tires);
        String tires2Name = tires[tires2Index];

        String[] gliders = {"Super Glider", "Cloud Glider", "Wario Wing", "Waddle Wing", "Peach Parasol", "Parachute", "Parafoil", "Flower Glider", "Bowser Kite", "Plane Glider", "MKTV Parafoil", "Gold Glider", "Hylian Kite", "Paraglider", "Paper Glider"};
        int glider1Index = getRandomIndex(gliders);
        String glider1Name = gliders[glider1Index];
        int glider2Index = getRandomIndex(gliders);
        String glider2Name = gliders[glider2Index];

        text1.setText(getDisplayString(character1Name, character1Index));
        text2.setText(getDisplayString(kart1Name, kart1Index));
        text3.setText(getDisplayString(tires1Name, tires1Index));
        text4.setText(getDisplayString(glider1Name, glider1Index));
        text5.setText(getDisplayString(character2Name, character2Index));
        text6.setText(getDisplayString(kart2Name, kart2Index));
        text7.setText(getDisplayString(tires2Name, tires2Index));
        text8.setText(getDisplayString(glider2Name, glider2Index));

        playSounds(character1Name, character2Name, null, null);
    }

    /**
     * Get random characters and board for Fortune Street
     * @param view
     */
    public void fortuneClicked(View view) {
        stopMediaPlayers();

        String[] characters = {"Mario", "Luigi", "Yoshi", "Birdo", "Donkey Kong", "Diddy Kong", "Slime", "Platypunk", "Alena", "Kiryl", "Wario", "Waluigi", "Daisy", "Peach", "Dragonlord", "Jessica", "Patty", "Stella", "Princessa", "Bianca", "Bowser", "Bowser Jr.", "Toad", "Mii!!!", "Yangus", "Angelo", "Carver"};
        int character1Index = getRandomIndex(characters);
        String character1Name = characters[character1Index];
        int character2Index = getRandomIndex(characters);
        // No duplicate characters
        while (character2Index == character1Index){
            character2Index = getRandomIndex(characters);
        }
        String character2Name = characters[character2Index];
        int character3Index = getRandomIndex(characters);
        // No duplicate characters
        while (character3Index == character2Index || character3Index == character1Index){
            character3Index = getRandomIndex(characters);
        }
        String character3Name = characters[character3Index];
        int character4Index = getRandomIndex(characters);
        // No duplicate characters
        while (character4Index == character3Index || character4Index == character2Index || character4Index == character1Index){
            character4Index = getRandomIndex(characters);
        }
        String character4Name = characters[character4Index];

        String[][] boards = {{"Castle Trodain", "true"}, {"The Observatory", "maybe"}, {"Ghost Ship", "true"}, {"Slimenia", "true"}, {"Mt Magmageddon", "false"}, {"Robbin' Hood Ruins", "false"}, {"Mario Stadium", "true"}, {"Starship Mario", "maybe"}, {"Mario Circuit", "true"}, {"Yoshi's Island", "true"}, {"Delfino Plaza", "false"}, {"Peach's Castle", "true"}, {"Alefgard", "true"}, {"Super Mario Bros.", "true"}, {"Bowser's Castle", "false"}, {"Good Egg Galaxy", "maybe"}, {"Colossus", "false"}, {"Alltrades Abbey", "maybe"}};
        int boardIndex = getRandomIndex(boards);
        String boardName = boards[boardIndex][0];
        String plot = boards[boardIndex][1];

        text1.setText(getDisplayString(character1Name, character1Index));
        text2.setText(getDisplayString(character2Name, character2Index));
        text3.setText(getDisplayString(character3Name, character3Index));
        text4.setText(getDisplayString(character4Name, character4Index));
        text5.setText(getDisplayString(boardName, boardIndex));
        text6.setText(plot == "true" ? "A few vacant plots" : plot == "false" ? "No vacant plots" : "Maybe add vacant plots");
        text7.setText("");
        text8.setText("");

        playSounds(character1Name, character2Name, character3Name, character4Name);
    }

    /**
     * Get random characters and map for Mario Strikers
     * @param view
     */
    public void strikersClicked(View view) {
        stopMediaPlayers();

        String[] characters = {"Mario", "Daisy", "Donkey Kong", "Luigi", "Super Team", "Peach", "Wario", "Waluigi", "Yoshi"};
        int character1Index = getRandomIndex(characters);
        String character1Name = characters[character1Index];
        int character2Index = getRandomIndex(characters);
        // No duplicate characters
        while (character2Index == character1Index){
            character2Index = getRandomIndex(characters);
        }
        String character2Name = characters[character2Index];

        String[] sidekicks = {"Toad", "Hammer Bro", "Birdo", "Koopa Troopa"};
        int sidekick1Index = getRandomIndex(sidekicks);
        String sidekick1Name = sidekicks[sidekick1Index];
        int sidekick2Index = getRandomIndex(sidekicks);
        String sidekick2Name = sidekicks[sidekick2Index];

        String[] stages = {"The Palace", "Pipeline Central", "The Underground", "Konga Coliseum", "Crater Field", "The Battle Dome", "Bowser Stadium"};
        int stageIndex = getRandomIndex(stages);
        String stageName = stages[stageIndex];

        text1.setText(character1Name);
        text2.setText(sidekick1Name);
        text3.setText(character2Name);
        text4.setText(sidekick2Name);
        text5.setText(getDisplayString(stageName, stageIndex));
        text6.setText("");
        text7.setText("");
        text8.setText("");

        playSounds(character1Name, sidekick1Name, character2Name, sidekick2Name);
    }

    /**
     * Change some smash characters names based on their costumes
     * @param name
     * @param costumeIndex
     * @return the new modified name
     */
    private String getNewSmashName(String name, int costumeIndex) {
        String newName = "";
        if (name == "Bowser Jr.") {
            if (costumeIndex == 1) newName = "Larry";
            else if (costumeIndex == 2) newName = "Roy";
            else if (costumeIndex == 3) newName = "Wendy";
            else if (costumeIndex == 4) newName = "Iggy";
            else if (costumeIndex == 5) newName = "Morton";
            else if (costumeIndex == 6) newName = "Lemmy";
            else if (costumeIndex == 7) newName = "Ludwig";
        }
        else if (name == "Olimar") {
            if (costumeIndex > 3) newName = "Alph";
        }
        else if (name == "Steve") {
            if (costumeIndex == 1 || costumeIndex == 3 || costumeIndex == 5) newName = "Alex";
            else if (costumeIndex == 6) newName = "Zombie";
            else if (costumeIndex == 7) newName = "Enderman";
        }
        else if (name == "Shulk") {
            if (costumeIndex == 7) newName = "Shirtless!";
        }
        return newName;
    }

    /**
     * Get random stuff for Smash Bros Ultimate
     * @param view
     */
    public void smashClicked(View view) {
        stopMediaPlayers();

        String[] characters = {"Mario", "Donkey Kong", "Link", "Samus", "Dark Samus", "Yoshi", "Kirby", "Fox", "Pikachu", "Luigi", "Ness", "Captain Falcon", "Jigglypuff", "Peach", "Daisy", "Bowser", "Ice Climbers", "Sheik", "Zelda", "Dr. Mario", "Pichu", "Falco", "Marth", "Lucina", "Young Link", "Ganondorf", "Mewtwo", "Roy", "Chrom", "Mr. Game & Watch", "Meta Knight", "Pit", "Dark Pit", "Zero Suit Samus", "Wario", "Snake", "Ike", "Pokémon Trainer", "Diddy Kong", "Lucas", "Sonic", "King Dedede", "Olimar", "Lucario", "R.O.B.", "Toon Link", "Wolf", "Villager", "Mega Man", "Wii Fit Trainer", "Rosalina & Luma", "Little Mac", "Greninja", "Palutena", "Pac-Man", "Robin", "Shulk", "Bowser Jr.", "Duck Hunt", "Ryu", "Ken", "Cloud", "Corrin", "Bayonetta", "Inkling", "Ridley", "Simon", "Richter", "King K. Rool", "Isabelle", "Incineroar", "Piranha Plant", "Joker", "Hero", "Banjo & Kazooie", "Terry", "Byleth", "Min Min", "Steve", "Sephiroth", "Pyra/Mythra", "Kazuya", "Sora", "Mii!!! Brawler", "Mii!!! Swordfighter", "Mii!!! Gunner"};
        int character1Index = getRandomIndex(characters);
        String character1Name = characters[character1Index];
        int character2Index = getRandomIndex(characters);
        String character2Name = characters[character2Index];

        String[] costumes = {"1st Costume", "2nd Costume", "3rd Costume", "4th Costume", "5th Costume", "6th Costume", "7th Costume", "8th Costume"};
        int costume1Index = getRandomIndex(costumes);
        String costume1Name = costumes[costume1Index];
        String easterEggName1 = getNewSmashName(character1Name, costume1Index);
        if (easterEggName1 != "") costume1Name += " (" + easterEggName1 + ")";
        int costume2Index = getRandomIndex(costumes);
        String costume2Name = costumes[costume2Index];
        String easterEggName2 = getNewSmashName(character2Name, costume2Index);
        if (easterEggName2 != "") costume2Name += " (" + easterEggName2 + ")";

        String[] types = {"Time", "Stock", "1-on-1", "5 v 3", "Special Smash", "Spirit Battle"};
        int typeIndex = getRandomIndex(types);
        String typeName = types[typeIndex];

        String[] stages = {"Regular Stage", "Battlefield and Omega", "Tournament/No Hazards"};
        int stageIndex = getRandomIndex(stages);
        String stageName = stages[stageIndex];

        String[] items = {"No Items", "Smash Orb Only", "All Items"};
        int itemIndex = getRandomIndex(items);
        String itemName = items[itemIndex];

        String[] fs = {"FS Meter On", "FS Meter Off"};
        int fsIndex = getRandomIndex(fs);
        String fsName = fs[fsIndex];

        text1.setText(getDisplayString(character1Name, character1Index));
        text2.setText(costume1Name);
        text3.setText(getDisplayString(character2Name, character2Index));
        text4.setText(costume2Name);
        text5.setText(typeName);
        text6.setText(stageName);
        text7.setText(itemName);
        text8.setText(fsName);

        playSounds(character1Name, character2Name, null, null);
    }

    /**
     * Get random stuff for Mario Golf Toadstool Tour
     * @param view
     */
    public void golfClicked(View view) {
        stopMediaPlayers();

        String[] characters = {"Mario", "Luigi", "Peach", "Daisy", "Yoshi", "Koopa Troopa", "Donkey Kong", "Diddy Kong", "Wario", "Waluigi", "Birdo", "Bowser", "Bowser Jr.", "Boo!", "Shadow Mario", "Petey Piranha"};
        int character1Index = getRandomIndex(characters);
        String character1Name = characters[character1Index];
        int character2Index = getRandomIndex(characters);
        // No duplicate characters
        while (character2Index == character1Index){
            character2Index = getRandomIndex(characters);
        }
        String character2Name = characters[character2Index];

        String[] types = {"Stroke Play", "Match Play", "Doubles", "Ring Attack (Face-Off)", "Ring Attack (Challenge)", "Club Slots (4)", "Club Slots (3)", "Coin Attack (Quick Cash)", "Coin Attack (Cash Cup)", "Skins Match", "Near-Pin", "Side Game: Birdie Challenge", "Side Game: One-on, One-putt"};
        int typeIndex = getRandomIndex(types);
        String typeName = types[typeIndex];

        String[] courses = {"Lakitu Valley", "Cheep Cheep Falls", "Shifting Sands", "Blooper Bay", "Peach's Castle Grounds", "Bowser Badlands", "Congo Canopy"};
        int courseIndex = getRandomIndex(courses);
        String courseName = courses[courseIndex];

        text1.setText(getDisplayString(character1Name, character1Index));
        text2.setText(getDisplayString(character2Name, character2Index));
        text3.setText(getDisplayString(typeName, typeIndex));
        text4.setText(getDisplayString(courseName, courseIndex));
        text5.setText("");
        text6.setText("");
        text7.setText("");
        text8.setText("");

        playSounds(character1Name, character2Name, null, null);
    }

    /**
     * Get random boards/characters for Mario Party 4 and Superstars
     * @param view
     */
    public void partyClicked(View view) {
        stopMediaPlayers();

        String[] superstarsBoards = {"Yoshi's Tropical Island", "Space Land", "Peach's Birthday Cake", "Woody Woods", "Horror Land"};
        int superstarsIndex = getRandomIndex(superstarsBoards);
        String superstarsName = superstarsBoards[superstarsIndex];

        String[] party4Boards = {"Goomba's Greedy Gala", "Shy Guy's Jungle Jam", "Toad's Midway Madness", "Boo's Haunted Bash", "Koopa's Seaside Soiree", "Bowser's Gnarly Party"};
        int party4BoardIndex = getRandomIndex(party4Boards);
        String party4BoardName = party4Boards[party4BoardIndex];

        String[] characters = {"Mario", "Luigi", "Peach", "Yoshi", "Wario", "Donkey Kong", "Daisy", "Waluigi"};
        int character1Index = getRandomIndex(characters);
        String character1Name = characters[character1Index];
        int character2Index = getRandomIndex(characters);
        // No duplicate characters
        while (character2Index == character1Index){
            character2Index = getRandomIndex(characters);
        }
        String character2Name = characters[character2Index];

        text1.setText("Superstars:");
        text2.setText(superstarsName);
        text3.setText("");
        text4.setText("Party 4:");
        text5.setText(party4BoardName);
        text6.setText(character1Name);
        text7.setText(character2Name);
        text8.setText("");

        playSounds(superstarsName == "Peach's Birthday Cake" ? "Peach" : null, character1Name, character2Name, null);
    }

    /**
     * Get random game to play
     * @param view
     */
    public void gameClicked(View view) {
        stopMediaPlayers();

        String[] games = {"Sacrifice Darren to the Sun God", "Rocket League", "Fall Guys", "Fortune Street", "Smash", "Mario Kart", "Mario Party Superstars", "Mario Party 4", "Mario Golf", "Mario Tennis", "Original Strikers", "Strikers: Battle League", "Mario Superstar Baseball"};
        int gameIndex = getRandomIndex(games);
        String gameName = games[gameIndex];

        text1.setText(gameName);
        text2.setText("");
        text3.setText("");
        text4.setText("");
        text5.setText("");
        text6.setText("");
        text7.setText("");
        text8.setText("");
    }
}
