package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Utils {

    public static LocalDate converterData(String data){
        DateTimeFormatter formatadorDeDatas = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(data, formatadorDeDatas);
    }

    public static String formatarData(LocalDate data) throws ParseException {
        SimpleDateFormat dataDeEntrada = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat dataDeSaida = new SimpleDateFormat("dd/MM/yyyy");

        return dataDeSaida.format(dataDeEntrada.parse(data.toString()));
    }

    public static final long getDiferencaEmMeses(LocalDate data1, LocalDate data2) {
        YearMonth m1 = YearMonth.from(data1);
        YearMonth m2 = YearMonth.from(data2);

        return m1.until(m2, ChronoUnit.MONTHS) + 1;
    }
}
