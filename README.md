# Java projekt

## Opis programa

  Namen programa je kratkočasenje. Gre za igrico 4 v vrsto. Pri tej igri se igralca izmenjujeta in želita čim hitreje povezati 4 svoje
  žetone. Igro se začne tako, da se zažene program, igra se začne s poljem dimenzij 6 × 7, le te pa lahko spreminjamo v meniju, vendar
  le v dimenziji 8×10 in 16×20. Igralca igrata tako, da klikneta na katerikoli stolpec in v najnižjem prstem mestu tega stolpca se bo 
  pokazal rdeč/rumen krog, ki ponazarja žeton. Ko enemu od igralcev uspe povezati 4 žetone se čez te 4 žetone nariše črta, ki označuje,
  kateri štirje žetoni so povezani in tako razkriva zmagovalca. Če pride do izenačenega izida je potrebno igro "ročno" zagnati znova in
  sicer tako, da v meniju izberemo dimezijo s katero želimo igrati ali pa le znova zaženemo program.

Program deluje tako, da se nariše modro platno in na njem x × y belih krogcev - odvisno od dimenzij, ki si jih izberemo. Če okno povečamo
se krogci povečajo oz. če okno razpotegnemo v levo/desno se slednji centrirajo - postavijo na sredino modrega platna. S klikom miške na
določen stolpec se na najnižji, še bel krogec nariše rdeč/rumen korgec istih dimenzij. Trenutno stanje igre imamo shranjeno v 2d tabeli, ki
se vsako potezo spremeni. Po vsaki potezi z iterativno funkcijo preverimo, če so 4 žetoni iste barve že povezani in ko so, program čez te 4
nariše črno črto.

## Navodila za uporabo

 Program zaženemo in že smo pripravljeni na igro, v primeru, da nam začetna dimenzija polja (6×7) ne ustreza le to spremenimo v orodni
 vrstici in igramo, dokler nekdo ne zmaga.
