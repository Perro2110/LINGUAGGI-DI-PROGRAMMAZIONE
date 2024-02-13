import sys
import argparse

from Ricerca import Ricerca
from Innovazione import Innovazione
from Progetti import Progetti
from Ricercatore import Ricercatore
from Partecipazione import Partecipazione

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        progetti    = []
        ricercatori =  []
        CodTitolo   = {}

        try:
            f=open("progetti.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok  = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                titolo=line
                line = f.readline().strip()
                nomeEcognome = line
                line = f.readline().strip()
                organizzazione = line
                if(tipo=="ricerca"):
                    line = f.readline().strip()
                    tok=line.split()
                    codArgomento = str(tok[0])
                    numeroPartner = int(tok[1])
                    line = f.readline().strip()
                    importoTotaleInMilioniDiEuro=float(line)
                    p=Ricerca(cod, tipo, titolo, nomeEcognome, organizzazione, importoTotaleInMilioniDiEuro,codArgomento,numeroPartner)
                if(tipo == "innovazione"):
                    line = f.readline().strip()
                    tok = line.split()
                    numeroAziendeCoinvolte = int(tok[0])
                    importoTotaleInMilioniDiEuro = float(tok[1])
                    p=Innovazione(cod, tipo, titolo, nomeEcognome, organizzazione, importoTotaleInMilioniDiEuro,numeroAziendeCoinvolte)
                progetti.append(p)
                CodTitolo[cod]=titolo
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f=open("riercatori.txt","r")
            line = f.readline().strip()
            while(line != ''):
                nome = line
                line = f.readline().strip()
                cognome = line
                r = Ricercatore(nome,cognome)
                line = f.readline().strip()
                
                OrarioTot =0
                numPart   =0
                impOrarMax = 0
                CodImpMax  = 0
    
                while(line != ''):
                    numPart = numPart + 1
                    tok = line.split()
                    codI=int(tok[0])
                    impiegoOrario = float(tok[1])
                    OrarioTot += impiegoOrario
                    part=Partecipazione(codI,impiegoOrario)
                    r.addPartecipazione(part)
                    if(impOrarMax < impiegoOrario):
                        impOrarMax = impiegoOrario
                        CodImpMax = codI
                    
                    line = f.readline().strip()

                r.setMassimi(impOrarMax,CodImpMax)
                r.setImpegnoOrario(OrarioTot)
                r.setNumeroProgetti(numPart)
                ricercatori.append(r)
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        print("tipo, titolo, codice, coordinatore, organizzazione, argomento,partner, aziende, importo totale in migliaia di euro")
        for p in progetti:
            print(p)
        
        print("") 

        for r in ricercatori:
            print(r)
        print()
        c = input("cognome: ")
        for r in ricercatori:
            if (c == r.getCognome()):
                print(r.getInfoUtili()+" "+CodTitolo[r.getMaxCod()])

if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()