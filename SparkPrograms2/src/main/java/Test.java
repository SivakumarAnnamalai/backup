import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.BadSecurityHandlerException;
import org.apache.pdfbox.util.PDFTextStripper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by sivakumaran on 8/1/2016.
 */
public class Test {
    public static void main(String args[]) throws CryptographyException, BadSecurityHandlerException {
        PDFTextStripper pdfStripper = null;
        PDDocument pdDoc = null;
        COSDocument cosDoc = null;
        File file = new File("C:\\Users\\sivakumaran\\Documents\\PDFExtractor\\26759538_REPAYMENT.pdf");
        try {
            PDFParser parser = new PDFParser(new FileInputStream(file));
            parser.parse();
            cosDoc = parser.getDocument();
            pdfStripper = new PDFTextStripper();
            pdDoc = new PDDocument(cosDoc);
            //password check
           /* boolean isOriginalDocEncrypted = pdDoc.isEncrypted();
            if (isOriginalDocEncrypted) {
                pdDoc.openProtection(new StandardDecryptionMaterial("njc5"));
            }*/
            //pdfStripper.setStartPage(1);
            //pdfStripper.setEndPage(5);

            String parsedText = pdfStripper.getText(pdDoc);
            System.out.println(parsedText);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
