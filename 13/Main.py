#8.50
#9.31
import sys
import argparse


from Spettacoli import Spettacoli
from Serie import Serie
from Film import Film
from Visualizzazioni import Visualizzazioni
from Elemento import Elemento


class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        spettacoli      = []
        visualizzazioni = []
        codTitolo = {}
        codTipo   = {}

        try:
            f=open("spettacoli.txt","r")
            line = f.readline().strip()
            while(line != ''):
                titolo =line
                line = f.readline().strip()
                tok = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                if(tipo == "serie"):
                    line = f.readline().strip()
                    tok = line.split()
                    stagione   = int(tok[0])
                    numPuntate = int(tok[1])
                if(tipo == "film"):
                    line = f.readline().strip()
                    durata = line
                
                line = f.readline().strip()
                produttore = line
                line = f.readline().strip()
                annoDiUscita = int(line)

                if(tipo == "serie"):
                    s = Serie(titolo, cod, tipo, produttore,annoDiUscita,stagione,numPuntate)
                if(tipo == "film"):
                    s=Film(titolo, cod, tipo, produttore, annoDiUscita,durata)
                
                spettacoli.append(s)
                codTitolo[cod]=titolo
                codTipo[cod]=tipo
                line = f.readline().strip()
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f=open("visualizzazioni.txt","r")
            line = f.readline().strip()
            while(line != ''):
                tok = line.split()
                codU = int(tok[0])
                nome = str(tok[1])
                cognome = str(tok[2])
                v = Visualizzazioni(codU,nome,cognome)
                line = f.readline().strip()
                tok = line.split()
                for i in range(len(tok)):
                    cod=int(tok[i])
                    elem = Elemento(cod,codTitolo[cod],codTipo[cod])
                    v.addElemento(elem)

                visualizzazioni.append(v)
                line = f.readline().strip()                
            f.close()
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)
        
        print("tipo, titolo, codice, stagione, n. puntate, durata, anno, produttore")
        for s in spettacoli:
            print(s)
        
        for v in visualizzazioni:
            print(v)
        
        for v in visualizzazioni:
            print(v.str2())

if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()