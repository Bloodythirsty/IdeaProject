import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestHuawei {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int[] scores = new int[26];
        for (int i = 0; i < scores.length; i++) {
            scores[i] = -1;
        }
        String str;
        while (sc.hasNext()){
            str = sc.nextLine();
            String[] s = str.split(" ");
            String team = s[0];
            String score = s[1];
            String[] split = score.split(":");
            int firstScore = Integer.parseInt(split[0]);
            int secondScore = Integer.parseInt(split[1]);
            int firstTeam = (int) team.charAt(0) - 97;
            int secondTeam = (int) team.charAt(2) - 97;

            if (scores[firstTeam]<0){
                scores[firstTeam]=0;
            }
            if (scores[secondTeam]<0){
                scores[secondTeam]=0;
            }

            if (firstScore > secondScore){
                scores[firstTeam] += 3;
            }else if (firstScore < secondScore){
                scores[secondTeam] += 3;
            }else {
                scores[firstTeam] += 1;
                scores[secondTeam] += 1;
            }
        }

        List<TeamScore> lists = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] >= 0) lists.add(new TeamScore((char)(i+97),scores[i]));
        }

        lists.sort((a,b)->{
            return b.getScore() - a.getScore();
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            sb.append(lists.get(i).getName()).append(" ").append(lists.get(i).getScore());
            if (i!=lists.size()-1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }


    @Test
    public void test(){
        List<TeamScore> lists = new ArrayList<>();
        lists.add(new TeamScore('a',10));
        lists.add(new TeamScore('b',1));
        lists.add(new TeamScore('d',2));
        lists.add(new TeamScore('c',2));

        lists.sort((a,b)->{
            return b.getScore() - a.getScore();
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lists.size(); i++) {
            sb.append(lists.get(i).getName()).append(" ").append(lists.get(i).getScore());
            if (i!=lists.size()-1){
                sb.append(",");
            }
        }
        System.out.println(sb.toString());
    }
}

class TeamScore{
    private char name;
    private int score;

    TeamScore(char name,int score){
        this.name = name;
        this.score = score;
    }

    public char getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
