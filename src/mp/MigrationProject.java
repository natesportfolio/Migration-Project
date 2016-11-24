package mp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class MigrationProject extends JFrame implements KeyListener {

    static MPPanel panel = new MPPanel();
    static JFrame infoPanel;
    static JTextArea info = new JTextArea();
    static JLabel timePeriod = new JLabel("Time Period");

    int iterations;

    public void addComponents() {
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));
        panel.setLayout(new BorderLayout());

        setContentPane(panel);
    }

    public static void main(String[] args) throws InterruptedException {
        MigrationProject frame = new MigrationProject("Migration Project");
        frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.addComponents();
        frame.setVisible(true);
        frame.setResizable(false);

        infoPanel = new JFrame("Info Panel");

        JPanel infoP = new JPanel();
        infoP.setBorder(new EmptyBorder(5, 5, 5, 5));
        infoP.setLayout(new BorderLayout());
        infoPanel.setContentPane(infoP);

        info.setLineWrap(true);
        info.setWrapStyleWord(true);
        info.setEditable(false);
        infoPanel.getContentPane().add(info);

        timePeriod.setHorizontalAlignment(JLabel.CENTER);
        infoPanel.getContentPane().add(timePeriod, BorderLayout.NORTH);

        infoPanel.addKeyListener(frame);
        infoPanel.getContentPane().setPreferredSize(new Dimension(200, 300));
        infoPanel.pack();
        infoPanel.setVisible(true);
    }

    public MigrationProject(String s) {
        super(s);

        addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 39 || e.getKeyCode() == 68) {
            determineNextTimePeriod();
        } else {
            infoPanel.requestFocus();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void pre160k() {
        timePeriod.setText("Pre-160k, African origin");
        info.setText("Over 160,000 years ago, Homo sapiens (today's humans) lived in Africa. The earliest known evidence of mtDNA and the Y chromosome ancestors is found in East Africa, near Ethiopia and Kenya.");

        panel.drawDot(740, 360);
    }

    public void y160kTo135k() {
        timePeriod.setText("160k-135k");
        info.setText("Four different groups travelled as hunter-gatherers to the Cape of Good Hope in the south, the Congo Basin in the southwest and the Ivory Coast in the west, carrying the mtDNA gene type \"L1\".");

        panel.drawAnimatedLine(740, 370, 740, 444);
        panel.drawAnimatedLine(740, 370, 655, 391);
        panel.drawAnimatedLine(740, 370, 594, 360);
        panel.drawAnimatedLine(740, 370, 760, 355);
        panel.drawAnimatedLine(738, 444, 674, 480);
        panel.drawDot(758, 344);
        panel.drawDot(740, 360);
    }

    public void y135kto115k() {
        timePeriod.setText("135k-115k");
        info.setText("One group travelled across the then-forest Sahara, through the northern gate, and then they followed the Nile up to the Levant.");

        panel.drawAnimatedLine(760, 355, 721, 267);
        panel.drawAnimatedLine(721, 267, 754, 250);
        panel.drawDot(754, 240);
        panel.drawDot(758, 344);
        panel.drawDot(740, 360);
    }

    public void y115kTo90k() {
        timePeriod.setText("115k-90k");
        info.setText("The branch that had reached the Levant died out by 90k years ago. Global freezing had turned the Levant and the Sahara into a massive desert. The Levant was reoccupied by Neanderthals later.");

        panel.clear(0, 0, 800, 345);
    }

    public void y90kTo85k() {
        timePeriod.setText("90k-85k");
        info.setText("85k years ago a group of people crossed the Red Sea's mouth, and then travelled as beach-combers along the south coast of the Arabian Peninsula to India.");

        panel.drawAnimatedLine(758, 354, 770, 330);
        panel.drawDot(770, 325);
        panel.drawDot(758, 344);
        panel.drawDot(740, 360);
    }

    public void y85kTo75k() {
        timePeriod.setText("85k-75k");
        info.setText("From Sri Lanka they continued on the Indian Ocean coast to west Indonesia, then a landmass that was attached to Asia. They followed the coast on to Borneo to South China.");

        panel.drawAnimatedLine(770, 330, 827, 289);
        panel.drawAnimatedLine(827, 289, 855, 288);
        panel.drawAnimatedLine(855, 288, 890, 352);
        panel.drawAnimatedLine(890, 352, 896, 324);
        panel.drawAnimatedLine(896, 324, 940, 298);
        panel.drawAnimatedLine(940, 298, 959, 324);
        panel.drawAnimatedLine(959, 324, 962, 370);
        panel.drawAnimatedLine(962, 370, 997, 403);
        panel.drawAnimatedLine(997, 403, 1038, 371);
        panel.drawAnimatedLine(1038, 371, 990, 320);
        panel.drawAnimatedLine(990, 320, 1033, 295);
        panel.drawDot(770, 325);
        panel.drawDot(758, 344);
        panel.drawDot(740, 360);
    }

    public void y74kMtToba() {
        timePeriod.setText("74k-Mt. Toba Eruption");
        info.setText("In the year 74,000, Mt. Toba super-erupted in Sumatra, causing a 6 year nuclear winter and a 1000 year ice-age. The population decreased to less than 10,000 adults. Volcanic ash up to 5 meters deep covered India and Pakistan. Side note: We were experiencing technical difficulties with the explosion effects and were running out of time.");
    }

    public void y74kTo65k() {
        timePeriod.setText("74k-65k");
        info.setText("After the massive eruption in India, humans repopulated. The crossed from Timor to Australia by boat, and from Borneo to New Guinea.");

        panel.drawAnimatedLine(1033, 295, 1044, 259);
        panel.drawAnimatedLine(1038, 371, 1096, 378);
        panel.drawAnimatedLine(1096, 378, 1143, 400);
        panel.drawAnimatedLine(997, 403, 1053, 410);
        panel.drawAnimatedLine(1053, 410, 1085, 424);
        panel.drawAnimatedLine(1085, 424, 1053, 444);
        panel.drawAnimatedLine(1085, 424, 1120, 445);
        panel.drawDot(962, 370);
    }

    public void y65kTo52k() {
        timePeriod.setText("65k-52k");
        info.setText("The planet warming significantly meant that people could start moving north to the Fertile Crescent to the Levant. For there they moved to Bosporus in Europe.");

        panel.drawAnimatedLine(827, 289, 758, 213);
        panel.drawAnimatedLine(1053, 444, 1026, 460);
        panel.drawAnimatedLine(1026, 460, 1029, 483);
        panel.drawAnimatedLine(1120, 445, 1161, 467);
        panel.drawAnimatedLine(1161, 467, 1164, 495);
    }

    public void y52kTo45k() {
        timePeriod.setText("52k-45k");
        info.setText("At this point there was a mini ice-age. The group that had moved past the Fertile Crescent went to Bulgaria. Stone tools progressed on the Danube to Hungary and Austria.");

        panel.drawAnimatedLine(1029, 483, 1033, 496);
        panel.drawAnimatedLine(1164, 495, 1141, 535);
        panel.drawAnimatedLine(758, 213, 706, 212);
        panel.drawAnimatedLine(706, 212, 674, 183);
        panel.drawAnimatedLine(674, 183, 610, 186);
        panel.drawAnimatedLine(610, 186, 605, 203);
    }

    public void y45kTo40k() {
        timePeriod.setText("45k-40k");
        info.setText("People form the East Asian coast started moving west to the steppes of central Asia towards Northeast Asia. They moved form Pakistan to Central Asia, and the Indo-Chinese moved to the Qing-hai Plateau via Tibet.");

        panel.drawAnimatedLine(1037, 247, 996, 220);
        panel.drawAnimatedLine(1028, 236, 1118, 150);
        panel.drawAnimatedLine(1118, 150, 1114, 231);
        panel.drawAnimatedLine(940, 289, 961, 249);
        panel.drawAnimatedLine(961, 249, 945, 221);
        panel.drawAnimatedLine(855, 288, 884, 166);
        panel.drawAnimatedLine(884, 166, 960, 140);
        panel.drawAnimatedLine(801, 251, 833, 171);
        panel.drawAnimatedLine(833, 171, 877, 158);
        panel.drawAnimatedLine(758, 213, 734, 263);
        panel.drawAnimatedLine(734, 263, 674, 266);
        panel.drawAnimatedLine(605, 203, 576, 225);
    }

    public void y40kTo25k() {
        timePeriod.setText("40k-25k");
        info.setText("The Central Asian group moved west to eastern Europe, north to the Arctic Circle and joined the East Asians to start the spread into northeast Eurasia. It was during this time period that works of art began showing up in caves.");

        panel.drawAnimatedLine(945, 221, 996, 220);
        panel.drawAnimatedLine(996, 220, 1120, 74);
        panel.drawAnimatedLine(1120, 74, 1230, 74);
        panel.drawAnimatedLine(1118, 150, 1092, 135);
        panel.drawAnimatedLine(1092, 135, 1125, 100);
        panel.drawAnimatedLine(1125, 100, 1218, 98);
        panel.drawAnimatedLine(960, 140, 1112, 40);
        panel.drawAnimatedLine(1112, 40, 1226, 47);
        panel.drawAnimatedLine(1079, 60, 1079, 34);
        panel.drawAnimatedLine(833, 171, 701, 161);
        panel.drawAnimatedLine(758, 213, 754, 161);
        panel.drawAnimatedLine(833, 171, 824, 55);
    }

    public void y25kTo22k() {
        timePeriod.setText("25k-22k");
        info.setText("The ancestors of the Native Americas who crossed the Bering land bridge connecting Siberia and Alaska either passed through the ice corridor and reached Meadowcroft before the LGM, or took the coastal route.");

        panel.drawAnimatedLine(17, 74, 103, 74);
        panel.drawAnimatedLine(103, 74, 188, 155);
        panel.drawAnimatedLine(188, 155, 328, 213);
        panel.drawAnimatedLine(41, 74, 41, 108);
        panel.drawAnimatedLine(41, 108, 70, 98);
        panel.drawAnimatedLine(70, 98, 119, 117);
    }

    public void y22kTo19k() {
        timePeriod.setText("22k-19k");
        info.setText("During the last Ice Age, Asia, North America and Northern Europe were de-populated. Isolated groups managed to survive by staying in small refuges. In North America, both ways of going south were closed off by the ice.");

        panel.clear(0, 0, getWidth(), 140);
    }

    public void y19kTo15k() {
        timePeriod.setText("19k-15k");
        info.setText("The LGM happened. In North America, groups continued to develop their cultures south of the ice.");

        panel.drawAnimatedLine(325, 206, 299, 256);
        panel.drawAnimatedLine(299, 256, 259, 256);
        panel.drawAnimatedLine(259, 256, 243, 270);
        panel.drawAnimatedLine(243, 270, 243, 299);
        panel.drawAnimatedLine(243, 299, 319, 349);
        panel.drawAnimatedLine(319, 349, 371, 344);
        panel.drawAnimatedLine(371, 344, 415, 376);
    }

    public void y15kTo12500() {
        timePeriod.setText("15k-12.5k");
        info.setText("The climate began to get warmer. The coastal route of America began to reappear. People began to populate South Ameria, and tools such as flakes and cobbles have been found from that period.");

        panel.drawAnimatedLine(23, 74, 93, 74);
        panel.drawAnimatedLine(41, 74, 46, 106);
        panel.drawAnimatedLine(46, 106, 67, 97);
        panel.drawAnimatedLine(67, 97, 99, 107);
        panel.drawAnimatedLine(99, 107, 130, 140);
        panel.drawAnimatedLine(1096, 132, 1123, 103);
        panel.drawAnimatedLine(1123, 103, 1236, 103);
        panel.drawAnimatedLine(1059, 132, 1126, 79);
        panel.drawAnimatedLine(1126, 79, 1241, 75);
        panel.drawAnimatedLine(952, 132, 1122, 52);
        panel.drawAnimatedLine(1122, 52, 1243, 52);
        panel.drawAnimatedLine(130, 140, 161, 168);
        panel.drawAnimatedLine(161, 168, 165, 237);
        panel.drawAnimatedLine(165, 237, 202, 293);
        panel.drawAnimatedLine(202, 293, 226, 301);
        panel.drawAnimatedLine(226, 301, 326, 353);
        panel.drawAnimatedLine(326, 353, 315, 389);
        panel.drawAnimatedLine(315, 389, 333, 427);
        panel.drawAnimatedLine(333, 427, 357, 444);
        panel.drawAnimatedLine(357, 444, 335, 561);
        panel.drawAnimatedLine(415, 376, 470, 402);
        panel.drawAnimatedLine(470, 402, 455, 418);
        panel.drawAnimatedLine(455, 418, 447, 452);
        panel.drawAnimatedLine(447, 452, 418, 462);
        panel.drawAnimatedLine(418, 462, 388, 517);
        panel.drawAnimatedLine(388, 517, 364, 530);
        panel.drawAnimatedLine(364, 530, 357, 558);
        panel.drawAnimatedLine(357, 558, 349, 593);
        panel.drawAnimatedLine(356, 353, 357, 366);
        panel.drawAnimatedLine(427, 383, 394, 394);
        panel.drawAnimatedLine(204, 292, 219, 256);
        panel.drawAnimatedLine(179, 253, 218, 240);
    }

    public void y12500To10k() {
        timePeriod.setText("12.5k-10k");
        info.setText("The reoccupation of North America after the Ice Age happened in this period. In the sub-Arctic, people moved out from the Bering strait to the north to become Eskimos, Aluets and Na-Denes.");

        panel.drawAnimatedLine(94, 73, 154, 73);
        panel.drawAnimatedLine(124, 50, 141, 49);
        panel.drawAnimatedLine(141, 50, 184, 52);
        panel.drawAnimatedLine(124, 50, 111, 86);
        panel.drawAnimatedLine(153, 73, 180, 93);
        panel.drawAnimatedLine(318, 203, 348, 197);
        panel.drawAnimatedLine(165, 234, 192, 195);
    }

    public void y10kTo8k() {
        timePeriod.setText("10k-8k");
        info.setText("The glaciers of the Ice Age finally receding meant the begin of agriculture and farming. At this point, the Sahara was a grassland. This has been reinforced by life-size giraffe petroglyphs found in Niger. Britain and Scandinavia were recolonised at this point.");

        panel.drawAnimatedLine(728, 255, 706, 333);
        panel.drawAnimatedLine(728, 255, 665, 314);
        panel.drawAnimatedLine(606, 179, 587, 126);
        panel.drawAnimatedLine(606, 179, 707, 123);
        panel.drawAnimatedLine(822, 135, 822, 77);
        panel.drawAnimatedLine(704, 112, 704, 50);
        panel.drawAnimatedLine(957, 118, 957, 73);
    }

    public void determineNextTimePeriod() {
        iterations++;

        if (iterations == 1) {
            pre160k();
        } else if (iterations == 2) {
            y160kTo135k();
        } else if (iterations == 3) {
            y135kto115k();
        } else if (iterations == 4) {
            y115kTo90k();
        } else if (iterations == 5) {
            y90kTo85k();
        } else if (iterations == 6) {
            y85kTo75k();
        } else if (iterations == 7) {
            y74kMtToba();
        } else if (iterations == 8) {
            y74kTo65k();
        } else if (iterations == 9) {
            y65kTo52k();
        } else if (iterations == 10) {
            y52kTo45k();
        } else if (iterations == 11) {
            y45kTo40k();
        } else if (iterations == 12) {
            y40kTo25k();
        } else if (iterations == 13) {
            y25kTo22k();
        } else if (iterations == 14) {
            y22kTo19k();
        } else if (iterations == 15) {
            y19kTo15k();
        } else if (iterations == 16) {
            y15kTo12500();
        } else if (iterations == 17) {
            y12500To10k();
        } else if (iterations == 18) {
            y10kTo8k();
        }
    }
}
