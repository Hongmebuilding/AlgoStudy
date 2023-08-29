
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        ArrayList<Integer> dwarf = new ArrayList<>();
        int sum = 0;
        int fakes = 0;

        for (int i = 0; i < 9; i++) {
            dwarf.add(Integer.parseInt(br.readLine()));
        }

        for (int i = 0; i < 9; i++) {
            sum += dwarf.get(i);
        }

        if(sum > 100){
            fakes = sum - 100;
        }

        int removeIdx1 = -1;
        int removeIdx2 = -1;

        for (int i = 0; i < 8; i++) {
            if(dwarf.size() == 7){
                break;
            }
            for (int j = i+1; j < 9; j++) {
                if(dwarf.get(i) + dwarf.get(j) == fakes){
                    removeIdx1 = i;
                    removeIdx2 = j;
                    break;
                }
            }
        }

        if(removeIdx1 != -1 && removeIdx2 != -1){
            dwarf.remove(removeIdx1);
            dwarf.remove(removeIdx2 - 1);
        }

        Collections.sort(dwarf);

        for(int i = 0; i < dwarf.size(); i++) {
            pw.println(dwarf.get(i));
        }

        pw.close();
        br.close();
    }
}
