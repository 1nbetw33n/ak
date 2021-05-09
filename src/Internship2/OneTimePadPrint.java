package Internship2;

public class OneTimePadPrint {

    final public static void main(final String[] ARGS) {

        String plainText1 = "JKKKPJHKCODRDHDXBEJM";
        String plainText2 = "FYWHXANMDZMTQQJXQBWD";
        String plainText3 = "LEJSCWXWVKDVAPWPBXWI";

        System.out.println(OneTimePad.encrypt(plainText1, "CORONACORONACORONACORONA"));



        String[] plains = "Rüstungsausgaben auf Rekordniveau,Sozialisten verteidigen wohl die Macht,Capri soll nicht vorpreschen,Darum gehts beim Bund-Länder-Treffen,Nomadland gewinnt den Oscar als bester Film,Wir haben dieses Unglück besiegt,Sieben-Tage-Inzidenz steigt,Mehr Geld für Rüstung - trotz Pandemie,Nawalnys Organisation vor dem Aus,Ein Fest für Independent-Filme,Bund zahlt 100 Millionen an Thomas-Cook-Kunden,Eine Plattform für den Hass,Deutlich mehr Todesfälle 2020 - Geburtendefizit steigt,Markt für Brennstoffzellen wächst,Arbeitsverbot für Nawalny-Organisationen,Staatsanwaltschaft erhebt Klage gegen weitere VW-Führungskräfte,Prozess gegen HDP-Politiker Demirtas hat begonnen,Frankreich lockert vorsichtig,Türkei geht erneut gegen mutmaßliche Gülen-Anhänger vor,Ein Jahr Landleben testen,Mittelständler in Sorge um Wirtschaftsstandort,Schweigen und Zensur in China,Noch heute profitieren einige wenige,Schneller impfen im Gefängnis,Sie redet - ich handle,EU verklagt AstraZeneca wegen Lieferverzögerungen,Stimmen für mehr Freiheiten werden lauter,Geschäftsklima in Deutschland nur minimal verbessert,Kardinal Marx soll Bundesverdienstkreuz trotz Kritik erhalten,Israel untersucht Fälle von Myokarditis,Israel schließt Gaza-Fischereizone nach Raketenbeschuss,Flick darf wohl gehen - Nagelsmann im Anflug,Hackerangriff beeinträchtigt Madsack-Verlag,Russland weist italienischen Diplomaten aus,Erster deutscher Bürgerrat für Klimapolitik gestartet,Fast 100 Festnahmen bei Großeinsatz gegen Mafia in Italien,Hilfe für Indien rollt an,FDP und mehrere Abgeordnete klagen gegen Bundesnotbremse,Verschleppte die BaFin die Aufdeckung?,Impf-Priorisierung soll im Juni aufgehoben werden,Werbewirtschaft beschwert sich bei Kartellamt über Apple,Klimaneutralität in Deutschland schon 2045 möglich,Duell von Tesla und VW um die Spitze,Ermittlungsverfahren gegen Amtsrichter,Kanye Wests Sneakers für Rekordsumme versteigert,Streit mit Frankreich über Atomkraft,Das sind die Ergebnisse des Impfgipfels,Von der Leyen fühlte sich herabgesetzt,Es droht eine gesellschaftliche Schieflage,USA wollen bis zu 60 Millionen AstraZenecaImpfdosen exportieren,Bereit für die Tech-Giganten,Ein Gipfel der Hoffnung".replaceAll(" ", "").replaceAll("-", "").split(",");

        StringBuilder plainText = new StringBuilder();
        for (String str: plains) {
            if (str.length() == 20) {
                plainText.append(str);
            }
        }


        System.out.println(plainText.toString());
        System.out.println(OneTimePad.encrypt("Tourismusinitalien", "CORONACORONACORONACORONA"));



    }
}
