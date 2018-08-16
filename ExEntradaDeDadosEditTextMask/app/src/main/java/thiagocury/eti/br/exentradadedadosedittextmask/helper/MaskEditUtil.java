package thiagocury.eti.br.exentradadedadosedittextmask.helper;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class MaskEditUtil {

    public static final String FORMAT_CPF = "###.###.###-##";
    public static final String FORMAT_TELEFONE = "(##)####-#####";
    public static final String FORMAT_CEP = "#####-###";
    public static final String FORMAT_DATA = "##/##/####";
    public static final String FORMAT_HORA = "##:##";

    public static String unmask(final String s) {
        return s.replaceAll("[.]", "").replaceAll("[-]", "").replaceAll("[/]", "").replaceAll("[(]", "").replaceAll("[ ]","").replaceAll("[:]", "").replaceAll("[)]", "");
    }

    public static TextWatcher mask(final EditText et, final String mask) {
        return new TextWatcher() {
            boolean isUpdating;
            String old = "";
            public void onTextChanged(CharSequence s, int start, int before,int count) {
                String str = MaskEditUtil.unmask(s.toString());
                String mascara = "";
                if (isUpdating) {
                    old = str;
                    isUpdating = false;
                    return;
                }
                int i = 0;
                for (char m : mask.toCharArray()) {
                    if (m != '#' && str.length() > old.length()) {
                        mascara += m;
                        continue;
                    }
                    try {
                        mascara += str.charAt(i);
                    } catch (Exception e) {
                        break;
                    }
                    i++;
                }
                isUpdating = true;
                et.setText(mascara);
                et.setSelection(mascara.length());
            }
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void afterTextChanged(Editable s) {}
        };
    }
}