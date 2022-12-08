import java.util.HashMap;

class Solution {
    public static int firstUniqChar(String s) {
        // In real life, we'd just use a ordered hashmap, that way the second loop can be prevented
        HashMap<Character, Integer> mainMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            mainMap.put(c, (mainMap.get(c) == null) ? 1 : (mainMap.get(c) + 1));
        }

        for (int i = 0; i < s.length(); i++) {
            if (mainMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    // public static void main(String[] args) {
    //     firstUniqChar("mmestrsbrlktgkorlcnihdfwopqcgwsmehcvhahqlpvakkxmfuprbrehquexugctesjgaxcvhoswemaamknuddvlaoniwvopunbfxhdsgocngkqwxuakptxsogwnktnauabdsibwgivlhciwgrisehtfkuvxrahhmssxsbejamccwvhwbduekibduisfttvdmntsxuouebcbflwaqifrroinnjoirvpnuxfkcheglbmbtmntlrkijiajlijyjgudebqrbdjpdcbbaxtpkgujkatriwkbvwvqelthwitiovbbevanwpkemuovsakjlfbjuuocqfkqcktbhonendvkxfetlbaunljqnwteguxhbipksscvieustdknrifesxvuvxhectkwrbotdbooiiqeiwdtgmaackmvgafdltcmmdavtdkrdarjxfflbgcbfupuwjdqjmqbrhugdhogtuwawsqhswdwsnvahkblmolwinlqjgrdxdacgtvwrekplmobhcanmjecrvntpadcohwnibujgiaexdmiakqejmtfmgqftfvccobddtmpbrewhqvtjdatdqhpjbpqxvpecjadwloicaxubmjfcsqxkvqjapqerhahoimwtxkmrnqxgpjtdssswdxsjgepdejdwdfdjboeoiigwbnxukdtxbuluoktuurqcrkkppvpbjgjkruifjosobgssbdhupjpsluehbvnthmiqigpoqjajrojbvgulvbxojcaqjxxcehmrwvkhxemcsliktubrnijolfosnkexzjeodwmigawhegfgtmoorousbmonhomtwkiwxmkknfpsxxcevxdkpualdarkfvqvdbjqbnodtcgcsvptjvbnqkfxiiwxifhmhpvwdjhubqdgojsnovxpmpuirvgvhwjkqepxdrvoaopatsfjoivrsmumgphmmbxwxxudsvjpfnqxjbpgxnurtjvfhflvvnaqmiorqmcbdurdqfbwcnljieibdasoluepximluxadrehmihsaohkxhiukepcjoldvqxhqqvduwvucigkmneknqdbxatfeomwboewjkxmotopfjtjknmkrvopiidtjdxumlirudmtqiqbvlgqsposvmixmuishmmgmncqcdngcvcqcoggndcdihkanmcevcklsmtudjkpervgvkmmbbkuculdcxiinfrlgsleqxcnwoqdeopqhrlfkumplolpgnkwbojqplwrisufidaupkihsguujbkai");
    // }
}
