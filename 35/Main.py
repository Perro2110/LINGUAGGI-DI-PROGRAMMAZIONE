#16 16:50 
import sys
import argparse


from Squadra import Squadra
from Hockey import Hockey
from Pallamano import Pallamano
from Giocatori import Giocatori

class Main:
    def __init__(self,arg):
        self._arg = arg
    
    def main(self):
        squadre   = []
        giocatori = []
        codNomeSquadra = {}
        Tipo_NumPartiteVinte   = {}

        try:
            f=open("squadre.txt","r")
            line = f.readline().strip()
            Tipo_NumPartiteVinte["hockey"]=0
            Tipo_NumPartiteVinte["pallamano"]=0
            while(line != ''):
                tok = line.split()
                cod  = int(tok[0])
                tipo = str(tok[1])
                line = f.readline().strip()
                nomeSquadra = line
                if(tipo == "hockey"):
                    line = f.readline().strip()
                    tok = line.split()
                    numPartiteVinte = int(tok[0])
                    numPartitePerse = int(tok[1])
                    nMedioDiGoal    = float(tok[2])
                    nMedioDiFalli   = float(tok[3])
                    s = Hockey(cod, tipo, nomeSquadra, numPartiteVinte, numPartitePerse,nMedioDiGoal,nMedioDiFalli)
                if(tipo == "pallamano"):
                    line = f.readline().strip()
                    tok = line.split()
                    numPartiteVinte = int(tok[0])
                    numPartitePerse = int(tok[1])
                    nMedioDiGoalFatti  = float(tok[2])
                    s = Pallamano(cod, tipo, nomeSquadra, numPartiteVinte, numPartitePerse,nMedioDiGoalFatti)
                
                Tipo_NumPartiteVinte[tipo]=numPartiteVinte+Tipo_NumPartiteVinte[tipo]
                codNomeSquadra[cod]=nomeSquadra
                squadre.append(s)
                line = f.readline().strip()  # peche separate da unariga vuota
                line = f.readline().strip()                       
            f.close()   
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        try:
            f=open("giocatori.txt","r")
            line = f.readline().strip()
            while(line != ''):
                codSq = int(line)
                line = f.readline().strip()
                cognome = line
                line = f.readline().strip()
                nome = line
                line = f.readline().strip()
                tok = line.split()
                eta       = int(tok[0])
                numMaglia = int(tok[1])
                ruolo     = str(tok[2])
                titolare  = str(tok[3])
                g = Giocatori(codSq,cognome,nome,eta,numMaglia,ruolo,titolare,codNomeSquadra[codSq])
                giocatori.append(g)
                line = f.readline().strip()                       
            f.close()   
        except IOError as i:
            print(i)
        except Exception as e:
            print(e)

        print("nome della squadra, codice, n. partite vinte, n. partite perse,n. medio di gol, n. medio di falli, n. medio di reti, sport")
        for s in squadre:
            print(s)
        print(" ")
        print("nome, cognome, età, numero di maglia, ruolo, titolare, nome squadra")
        for g in giocatori:
            print(g)
        print(" ")
        print("media parte vinte delle squadre di hockey: " + str(Tipo_NumPartiteVinte["hockey"] / 2 ) )
        print("media parte vinte delle squadre di pallamano: " + str(Tipo_NumPartiteVinte["pallamano"] / 2 ) )


if __name__ == "__main__":
    g= Main(sys.argv)
    g.main()