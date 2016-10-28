package in.djtrinity.www.trinity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class EventDetailsActivity extends AppCompatActivity {

    private String eventName;
    private String description;
    private String date;
    private String contact;
    private boolean noNotif = false;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private NestedScrollView parentView;
    private String keyForPrefs = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        setContentView(R.layout.activity_event_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        eventName = getIntent().getExtras().getString("toolbarTitle");
        toolbar.setTitle(eventName);
        setSupportActionBar(toolbar);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        FloatingActionButton toolbarFab = (FloatingActionButton) findViewById(R.id.schedule_details_fab);
        parentView = (NestedScrollView) findViewById(R.id.schedule_details_nested_scroll_view);

        MainActivity.scheduleReturnFlag = true;

        keyForPrefs = eventName;
        setText();
        toolbarFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!noNotif)
                    setDataForNotif();
                else
                    Toast.makeText(getApplicationContext(), eventName + " has already been completed.", Toast.LENGTH_SHORT).show();
            }
        });
        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_event_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_share:
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, eventName + "\n\n" + date + "\n\n" + description + " or contact:\n" + contact);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
                break;

            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void setText() {
        TextView textHeader = (TextView) findViewById(R.id.schedule_details_text_header);
        TextView textView1 = (TextView) findViewById(R.id.schedule_details_text_info1);
        TextView textView2 = (TextView) findViewById(R.id.schedule_details_text_info2);
        TextView contactTextView = (TextView) findViewById(R.id.schedule_details_contact);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 21) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        String header;
        switch (eventName) {
            //Cultural
            case "Outhouse Treasure Hunt":
                header = "Cultural";
                description = "DJ's biggest Treasure hunt!\n" +
                        "Discover the twists and turns of this Bombay Monopoly, " +
                        "with mind boggling clues and questions, that will challenge even the brightest minds.";
                date = "Place: Essel World\n" +
                        "Date: 17th January";
                contact = "Contact the registration desk for more details.";
                noNotif = true;
                break;

            case "Fresher's Party":
                header = "Cultural";
                description = "An event to mark the end of crossroads and cherish new beginnings.\n" +
                        "The Fresher's Party is a revelry marking a rebellious future!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 9th October 2015";
                contact = "Contact the registration desk for more details.";
                noNotif = true;
                break;

            case "Concert Night":
                header = "Cultural";
                description = "Our cultural flagship event, wherein we invite professional singers from Bollywood.\n" +
                        "A night to look forward to in any calendar year!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: Coming Soon";
                contact = "Contact the registration desk for more details.";
                break;

            case "Inter-Department Dance":
                header = "Cultural";
                description = "Yes we are well aware about your ability to groove to the tunes!\n" +
                        "And hence, we present the Inter-departmental dance competition, a perfect blend of dance as well as competitiveness.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 2nd March";
                contact = "Contact the registration desk for more details.";
                break;

            case "Battleship":
                header = "Cultural";
                description = "Aloha mates!\n" +
                        "This is war and the battleships have disembarked to attack. The only way to prevent damage is by sinking your opponents ship.\n" +
                        "The catch?\n" +
                        "The ship could be present anywhere on the board and it's you're responsibility to figure out where, before it is too late.";
                date = "Place: DJ Sangvhi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Yash Agarwal: 9960016804";
                break;

            case "DJGT":
                header = "Cultural";
                description = "Our own talent hunt show, which is thrown open to the fellow Mumbaikars!\n" +
                        "A great opportunity to showcase your talent!";
                date = "Place: DJ Sangvhi\n" +
                        "Date: Ongoing. Finals on 11th March";
                contact = "Rushabh: 7498330001\n" +
                        "Alankar: 9820066476\n" +
                        "Swapnil: 8082022984";
                break;

            case "VCJA":
                header = "Cultural";
                description = "Coming Soon";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 7th January";
                contact = "Akash Tripathi: 8108774764\n" +
                        "Manan Shah: 998787331";
                noNotif = true;
                break;

            case "Haunted House":
                header = "Cultural";
                description = "Get ready to have your wits shaken.\n" +
                        "Feel your blood curdle and your spine tingle in the scariest corner of Trinity.\n";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Shreya Shetty: 9833469340";
                break;

            case "Street Play":
                header = "Cultural";
                description = "Play out a revolution!\n" +
                        "Shed light on the hurdles plaguing the society.\n" +
                        "Let your dramaturgy shine and compel bystanders to stop and clap their hearts out!\n" +
                        "Prizes worth 6k to be won!";
                date = "Place: JRM Grounds\n" +
                        "Date: 13th March";
                contact = "Rushi Maniar: 9969387898";
                break;

            case "DJ MUN":
                header = "Cultural";
                description = "Represent a nation in this formal war of words and speak about the latest trivial global issues.\n";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th March";
                contact = "Contact the registration desk for more details.";
                break;

            case "Murder Mystery":
                header = "Cultural";
                description = "In the hangover of the latest Sherlock episode, race through " +
                        "a pyramid of clues and work your way to bottom of each and every mystery. " +
                        "Put your brains to use by deciphering the signs and understanding the " +
                        "writing between the lines.\n" +
                        "Each team must have 4 members.\n" +
                        "Prizes worth 20k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th March";
                contact = "Vinil Punjani: 9920020293";
                break;

            case "Chain Reaction":
                header = "Technical";
                description = "Watch all the events unfold in an exquisite game of dominos, " +
                        "falling in tandem.\n";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Dinesh Tripathi: 8286968454";
                break;

            case "Stand-Up Comedy":
                header = "Cultural";
                description = "Humour finds it's way, howsoever you try suppressing it!\n" +
                        "And why suppress? We've got our own Stand-Up Comedy competition!\n" +
                        "Prizes worth 3k to be won.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 12th-13th March";
                contact = "Prianjana Singh: 99004027783";
                break;

            case "Musician's War":
                header = "Cultural";
                description = "Guitar, drums, flute? Get it all and take part in a melodious stand off in this musical battle.\n" +
                        "Prizes worth 6k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th March";
                contact = "Pratik Jayarao: 9619843933";
                break;

            case "Escape The Room":
                header = "Cultural";
                description = "Get your team of sleuths to find a way out from the dreaded chamber unscrambling clues along the way.\n" +
                        "Each team must have 4 members.";
                date = "Place: DJ\n" +
                        "Date: 11th-12th-13th March";
                contact = "Ahmed Momin: 9167608490";
                break;

            case "Debate":
                header = "Cultural";
                description = "Can you prove your point with smart words and tacky one liners?\n" +
                        "Here's your chance to win the audience over.\n" +
                        "Each team must have 2 members.\n" +
                        "Prizes worth 10k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 13th March";
                contact = "Contact the registration desk for more details.";
                break;

            case "Quiz":
                header = "Cultural";
                description = "Test your skills and knowledge as the next Derek O'Brein in this brain racking challenge.\n" +
                        "Each team must have 2 members.\n" +
                        "Prizes worth 10k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 12th March";
                contact = "Contact the registration desk for more details.";
                break;

            case "Mr & Ms Trinity":
                header = "Cultural";
                description = "The Search is on! For the belle's and the beau's of the hour.\n" +
                        "The cream of the crowd.\n" +
                        "Watch the contestants display flair and genius in this battle featuring beauty and brains!\n" +
                        "Prizes worth 5k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-13th March";
                contact = "Saniya Mehta: 9920194922";
                break;

            case "Short Film Fest":
                header = "Cultural";
                description = "Roll, camera, action!\n" +
                        "Present your ideas on tape at the Cannes of Trinity.\n" +
                        "Prizes worth 3k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 13th March";
                contact = "Romil Shah: 9969279848";
                break;

            case "Photography":
                header = "Cultural";
                description = "Aim, click, shoot.\n" +
                        "Now's the time to let your camera and your snaps to do the talking.\n" +
                        "Prizes worth 5k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: Ongoing. Winning photographs are displayed in the college throughout the festival.";
                contact = "Alankar Aparajit: 9820066476";
                break;

            case "MasterChef":
                header = "Cultural";
                description = "Entree, main course, dessert. Can you do it all?\n" +
                        "Face off in the Trinity kitchen to earn your own chef's hat.\n" +
                        "Each team must have 2 members." +
                        "Prizes worth 5k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th March";
                contact = "Pranali Mane: 9702342246";
                break;

            case "Just A Minute (JAM)":
                header = "Cultural";
                description = "Get your words together to battle it out with words.\n" +
                        "You have a minute to dirty the battlefield.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th March";
                contact = "Neha Joshi: 9619832823";
                break;

            case "Graffiti":
                header = "Cultural";
                description = "Have you wanted to fill a wall with your artistic degisns without having it considered as vandalism?\n" +
                        "Do spray cans and plain walls get your fingers itching?\n" +
                        "Graffiti is where you'd want to be! It's not something you get to do everyday!\n" +
                        "Prizes worth 3k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th March";
                contact = "Raj Patel: 9820112796";
                break;

            case "Beg Borrow Steal":
                header = "Cultural";
                description = "Are you resourceful enough to get what you want?\n" +
                        "By any means necessary?\n" +
                        "Would you beg from a stranger, borrow from a friend or be gutsy enough to steal?\n" +
                        "Because here, the end justifies the means.\n" +
                        "Teams of atleast 3.\n" +
                        "Prizes worth 3k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th March";
                contact = "Saurav Yadav: 9594103420";
                break;

            case "Karaoke":
                header = "Cultural";
                description = "Whether you're a pitch-perfect singer or just a fun loving karaoke enthusiast, " +
                        "this is the perfect opportunity to let your inner star shine !\n";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Priyanka Kothari: 9757073787";
                break;

            case "Fine Arts":
                header = "Cultural";
                description = "A R T S ! \n" +
                        "These mere four letters come together to give a perfect blend of creativity and imagination!\n" +
                        "Prizes worth 6k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Dashank Gohil: 9920635585";
                break;

            case "Mad Ad":
                header = "Cultural";
                description = "With a unique concept, this event provides a platform to showcase your ability to perform yet be creative!\n" +
                        "Think you've got Mad Ad skills?\n" +
                        "Then participate in this event as you can create insane ads for a given product and perform in front of a live audience." +
                        "Prizes worth 3k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 13th March";
                contact = "Swapnel Desai: 8879083085";
                break;

            case "Silent Disco":
                header = "Cultural";
                description = "This event is incredible for you to forget the world for a bit, by plugging in those earphones. \n" +
                        "Loose yourself in the beat of the music and bring out your best moves in the Silent Disco";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Contact the registration desk for more details.";
                break;

            case "Brain 'N Brawn":
                header = "Cultural";
                description = "Coming Soon!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Aishwarya Acharya: 9619729561";
                break;
            //Technical
            case "Robowars":
                header = "Technical";
                description = "The futuristic version of UFC with robots duelling it out in the " +
                        "ring, competing to be the best in strength, will and engineering prowess.\n" +
                        "Each team must have 2 members.\n" +
                        "Prizes worth 35k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 12th-13th March";
                contact = "Angelo Francis: 7208033526";
                break;

            case "Trial By Combat":
                header = "Technical";
                description = "Game of Thrones freaks! " +
                        "An event not falling short of the battle between Sandor Clegane and " +
                        "Oberyn Martell, watch teams fight it out in the ring with swords and " +
                        "shields. Well, there's no Neil Nitin Mukesh.\n" +
                        "One on one event.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Pratik Tolani: 9769487632";
                break;

            case "Code Uncode":
                header = "Technical";
                description = "Do you have a smart eye in finding out meaning in utter garble?\n" +
                        "Do codes intrigue you into finding a solution?\n" +
                        "Can you crack the Da Vinci code and discover the Holy Grail?\n" +
                        "If yes, Code Uncode invites you all!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th March";
                contact = "Contact the registration desk for more details.";
                break;


            case "Roborace":
                header = "Technical";
                description = "Can your robot jump hurdles and sprint?\n" +
                        "Its time to assemble your mechanical Usain Bolts at the start of the track.\n" +
                        "Each team must have 2 members.\n" +
                        "Prizes worth 20k to be won!";
                date = "Place: JRM Grounds\n" +
                        "Date: 12th-13th March";
                contact = "Dinesh Tripathi: 8286968454";
                break;

            case "Robotics Workshop":
                header = "Technical";
                description = "TRINITY presents a Robotics Workshop for all you beginner tinkerers to learn how to delve into the world of bots.\n" +
                        "Here you can learn to build, right from scratch, bots like Line Follower, Obstacle Follower and Temperature Sensor.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 26th September 2015";
                contact = "Contact the registration desk for more details.\n" +
                        "Vatsal: 9096622846\n" +
                        "Mihin: 9920057737";
                break;

            case "Robo-Football":
                header = "Technical";
                description = "Test the skills of your robot on the football field and find the " +
                        "automated Messi and CR7.\n" +
                        "Each team must have 2 members.\n" +
                        "Prizes worth 20k to be won!";
                date = "Place: JRM Grounds\n" +
                        "Date: 12th-13th March";
                contact = "Arsalan Sheikh: 8451863384";
                break;

            case "Stock Market":
                header = "Technical";
                description = "Place your bets well in this trading game. Short your profits and cut your losses well and be the Ambani of Trinity.\n" +
                        "Prizes worth 5k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 12th March";
                contact = "Darshit Parekh: 9619001610";
                break;

            case "Laser Tag":
                header = "Technical";
                description = "Are you Counter Strike fiend? Test your skills in the real " +
                        "world with lasers and limited lives.\n" +
                        "Each team must have 4-5 members.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th March";
                contact = "Siddharth Kharbanda: 9167793501";
                break;

            case "Flex and Mascot":
                header = "Technical";
                description = "Sit back and enjoy the spectacular war between the departments," +
                        " as they put forth creativity and intellect, in the form of a Mascot and Flex!\n";
                date = "Place: BJ Hall\n" +
                        "Date: 12th January";
                contact = "Contact the registration desk for more details.";
                noNotif = true;
                break;

            case "TechExpo":
                header = "Technical";
                description = "The TechExpo of DJSCE caters to the technical aspect of Trinity and " +
                        "provides a stage to innovation, " +
                        "ideas and intelligence to shape a better future with technology right " +
                        "at out fingertips.\n" +
                        "Each team must have 4 members.\n" +
                        "Prizes worth 40k to be won!";
                date = "Place: JRM Grounds\n" +
                        "Date: 13th March";
                contact = "Jash Singhania: 7303810024";
                break;

            case "Technical Paper Presentation":
                header = "Technical";
                description = "Technical Paper Presentations are the best way to showcase " +
                        "your talents in research and development and that too in front of some of " +
                        "the most renowned and highly qualified judges in the field of engineering.\n" +
                        "Each team must have 4 memebrs.\n" +
                        "Prizes worth 70k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Rishab Haria: 9930804022";
                break;

            case "LAN Gaming":
                header = "Technical";
                description = "FIFA, Counter Strike, Dota- which game are you the best at? " +
                        "Prove your worth against the best oppositions as you face off on Lan servers.\n" +
                        "Counter Strike: 5 members in a team.\n" +
                        "FIFA 14: One on one.\n" +
                        "Need For Speed-Most Wanted 2: One on one.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "V Patel: 9833702255";
                break;

            case "IC Engine Car Race":
                header = "Technical";
                description = "Go-Karting fans, F1 fans? This is the ultimate event for all " +
                        "the engineers who are racing fanatics. Watch miniature prototypes and " +
                        "models screech on the tarmac and burn asphalt with the grit to " +
                        "cross the finish line before the rest.\n";
                date = "Place: Tilak Udyan\n" +
                        "Date: 23rd January";
                contact = "Contact the registration desk for more details.\n" +
                        "Ahmed Momin: 9167608490";
                noNotif = true;
                break;

            case "Junkyard Wars":
                header = "Technical";
                description = "Assemble your 9 pieces of 8 and raise your own Calypso to get " +
                        "your own territory in the war of best out of waste.\n" +
                        "Each team must have 2 members.\n" +
                        "Prizes worth 5k to be won!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 13th March";
                contact = "Parag Jain: 9699054808";
                break;

            case "Technical Attractions":
                header = "Technical";
                description = "Visiting Trinity this year maybe your best fest decision.\n" +
                        "Catch a glimpse of the Laser Harp, playing music on invisible strings,\n" +
                        "The Depolarised Monitor, to watch a display with a special set of glasses, and many more.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Contact the registration desk for more details.";
                break;
            //Sports
            case "Snookball":
                header = "Sports";
                description = "Battle it out with your FUT team in the box, " +
                        "for pride, for honor and for respect. Will it be the defence, " +
                        "the midfield, the attack or the referees which take you to the top of the table.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Sonali Varadam: 9022243052";
                break;

            case "Inter-Department Sports Day":
                header = "Sports";
                description = "Watch the 7 departments battle it out with grit and determination" +
                        " as their athletic abilities are put to test!\n";
                date = "Place: JRM Grounds\n" +
                        "Date: 25th January";
                contact = "Contact the registration desk for more details.";
                noNotif = true;
                break;

            case "Rink Football":
                header = "Sports";
                description = "Our life is a game of football, we are the players, trying to convert opportunities into goals!\n" +
                        "Philosophical much? Don't worry, we've got the sport.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 26th February";
                contact = "Contact the registration desk for more details.";
                break;

            case "Box Cricket":
                header = "Sports";
                description = "Amidst all the out-of-the-box events, this one has to be played inside the box, like literally.\n" +
                        " Introducing to you, a unique form of cricket, the Box Cricket!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 26th February";
                contact = "Contact the registration desk for more details.";
                break;

            case "Angry Birds":
                header = "Cultural";
                description = "You would be forgiven to think that concept of a life sized version of Angry birds would be a logical impossibility.\n" +
                        " We here at Trinity bring that dream to reality by pairing basic elements from the game and blowing it up to a life sized model!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th";
                contact = "Noopur Bapardakar: 9987844462";
                break;

            case "Target Shooting":
                header = "Sports";
                description = "Ever wanted to hold a rifle and fire a bullet. Ever felt the exhilaration and the rush after pulling the trigger?\n" +
                        "Target shooting bring you all these experiences.\n" +
                        "It's all a test accuracy, focus and having a hawk's eye.\n";
                date = "Place: JRM Grounds\n" +
                        "Date: 11th-12th-13th March";
                contact = "Aishwarya Acharya: 9619729561";
                break;

            case "Mini-Golf Course":
                header = "Sports";
                description = "Putt your way through fun-filled holes of 3D designed courses with elevated platforms, bunkers, bridges and many more exciting obstacles !";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Kushagrah Shah: 9820083571";
                break;

            case "Raftaar":
                header = "Sports";
                description = "Put your endurance to test if you think you can sustain a prolonged athletic output by partaking in this event!\n" +
                        "Dash your way through this course full of challenging obstacles that'll make you push your limits.\n" +
                        "Prizes worth 5k to be won!";
                date = "Place: JRM Grounds\n" +
                        "Date: 12th-13th March";
                contact = "Nikunj Waghasia: 9172808923";
                break;

            case "Sumo Wrestling":
                header = "Sports";
                description = "For once,being fat is awesome!\n" +
                        "Use your strength,speed and reach to knock your opponent out of the circle in the oldest of wrestling sport.\n" +
                        "One on One event.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 12th-13th March";
                contact = "Parag Jain: 9699054808";
                break;

            case "Glow Cricket":
                header = "Sports";
                description = "What's better than cricket?\n" +
                        "Glow-in-dark cricket. Where you and your team get to play a neon themed match. For once,bad light doesn't stop play.\n" +
                        "Each team must have 5 members.";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 11th-12th-13th March";
                contact = "Kushagra Shah: 9820083571";
                break;

            case "Amazing Race":
                header = "Sports";
                description = "What do you get when you add people who love to travel, and pit them against each other to complete the journey in the quickest time possible, all this while completing the said task at hand?\n" +
                        "You get The Amazing Race.\n" +
                        "Each team must have 2 members.\n";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 12th February";
                contact = "Kumpal Dhruv: 9167269077";
                break;

            case "Trinity Sports":
                header = "Sports";
                description = "A variety of sports and games await you at Trinity Sports, open for everyone.\n" +
                        "Participate in any and all sports you can think of and win big!";
                date = "Place: DJ Sanghvi\n" +
                        "Date: 26th-27th-28th February";
                contact = "Soumya Mahuvakar: 9833635101";
                noNotif = true;
                break;

            default:
                header = "Random";
                description = "Coming Soon";
                date = "Place: DJ Sanghvi\n" +
                        "Date: Coming Soon";
                contact = "Name: Number\n";
                break;
        }

        switch (header) {
            case "Technical":
                if (Build.VERSION.SDK_INT >= 21) {
                    window.setStatusBarColor(Color.parseColor("#000000"));
                }
                parentView.setBackgroundColor(Color.parseColor("#7986CB"));
                textHeader.setTextColor(Color.parseColor("#3F51B5"));
                //collapsingToolbarLayout.setBackgroundColor(Color.parseColor("#303F9F"));
                collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this, R.color.colorPrimaryTechnical));
                break;

            case "Cultural":
                if (Build.VERSION.SDK_INT >= 21) {
                    window.setStatusBarColor(Color.parseColor("#000000"));
                }
                parentView.setBackgroundColor(Color.parseColor("#4DD0E1"));
                textHeader.setTextColor(Color.parseColor("#00BCD4"));
                //collapsingToolbarLayout.setBackgroundColor(Color.parseColor("#00BCD4"));
                collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this, R.color.colorPrimaryCultural));
                break;

            case "Sports":
                if (Build.VERSION.SDK_INT >= 21) {
                    window.setStatusBarColor(Color.parseColor("#000000"));
                }
                parentView.setBackgroundColor(Color.parseColor("#90A4AE"));
                textHeader.setTextColor(Color.parseColor("#607D8B"));
                //collapsingToolbarLayout.setBackgroundColor(Color.parseColor("#607D8B"));
                collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(this, R.color.colorPrimarySports));
                break;
        }

        description = description + "\nFor more details visit www.djtrinity.in";
        textHeader.setText(header);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTrinity(v);
            }
        });
        textView1.setText(description);
        textView2.setText(date);
        contactTextView.setText(contact);
    }

    public void setDataForNotif() {
        boolean notifCheck;
        SharedPreferences preferences = getApplicationContext().getSharedPreferences("NotifPref", 0);
        notifCheck = preferences.getBoolean(keyForPrefs, false);
        DialogNotif DialogNotif = new DialogNotif();
        DialogNotif.getData(keyForPrefs, notifCheck);
        DialogNotif.show(getFragmentManager(), "DIALOG TAG");
    }

    public void openTrinity(View view) {
        Uri uri = Uri.parse("http://www.djtrinity.in/home.php");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}