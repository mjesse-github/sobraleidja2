OOP projekt II
Autorid: Mihkel Jesse & Kirke Valt

Programmi kirjeldus
Tegime oma teiseks projektiks graafikaliidese esimesele, kus enam ei pea sisestama asju manuaalselt täpselt õigesti kirjutades vaid saab valida vastavate vastusevariantide vahel.
Erindiga kontrollib kood, et ise sisestatav lemmiknumber oleks alati number.

Programmi eesmärk
Programmi eesmärk on leida sõpru, küsides selleks väga olulisi ja spetsiifilisi küsimusi, et leida selline tegelane, kes kasutajaga kõige sarnasem on.

Graafikaliides kuvab ekraanile küsimustiku kus saab vastavalt vastuse kirjutada või variantidest valida. Välja tühjaks jätmisel kuvatakse ekraanile veateade tühjaks jäetud välja jaoks.

Lõime ka erindi mis kontrolliks, et vanus oleks alati number.
nupuvajutusega leiab sobiva kandidaadi ja kuvab ekraanile mingi jubeda graafikaliidese tema detailidega (nimi, vanus ja siis mingi loll joonistus nt?).

Muidu töötab programm täpselt nii nagu esimene projekt, lihtsalt terminali asemel on sisestamiseks graafikaliides. Pärast vastamist kirjutab programmi uue sisestatud info faili.

Klassid
Muudatusi tegime ainult Application klassis, muud klassid jätsime eelmisest projektist samaks. 
Applicationis on kõigepealt  defineerime isendimuutujad ja nende omadused. Peaklassis loome pealava kuhu  gridiga lisada vastavaid kastikesi. Pärast kastikestesse info sisestamist leiab programm meetodiga leiaMatchid leiab vastavatele tingimustele sobiva(d) kandidaadi(d) ja väljastab ekraanile nende nime(d) ja vanuse(d). Kui aga sobivat kandidaati ei leidu, väljastab ekraanile vastava teate.

VanuseErindi klass kutsutakse välja juhul kui vanuse kasti sisestatud info ei ole integeri kujul

Programm kirjutab kasutaja sisestatud andmed samasse faili, pakkudes selle variandiks uutele kasutajatele.

Isiku klassi läbi saame luua isikute objekte, mis salvestab kõik andmed ning aitab pärast võrrelda teiste isikutega.
Peaklassis toimub faili sisselugemine, informatsiooni sisestamine, sõprade leidmine ning lõpuks ka faili väljundina lisandunud kasutaja kirjutamine.

programmi protsess - rühmaliikmete panus + ajakulu
Esmalt tuletasime meelde ja käisime läbi kogu oma eelmise koodi ning koos istudes mõtlesime välja milline võiks olla selle koodi graafikaliides.
Kogu protsessi tegime kahekesi koos ja see võttis aega umbes 2 õhtut.

Tegemise mured
Kuna Mihkel oli varem graafikaliidestega kokku puutunud, siis ei valmistanud selle projekti kirjutamine erilist muret ning kõik vead said kiirelt ja jooksvalt parandatud.

Hinnang
Koostöö sujus ja saime seekord projekti õigeaegselt valmis:).
Testimine
Lasime programmi testida väga mitmel tegelasel, kes programmi valmimisel Deltas meie lähedal olid - kinnitasid, et kood töötas ilusti ning testimisprotsess oli väga väga lõbus :)!
