package com.cesena.milanoBlu.Faq;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupExpandListener;

import com.cesenaTeam.milanoBlu.R;

public class FaqFragment extends Fragment {
	
	int lastGroup = -1;
	ExpandableListAdapter listAdapter;
	ExpandableListView expListView;
	List<String> listDataHeader;
	HashMap<String, List<String>> listDataChild;
	
	public static Fragment newInstance() {
		FaqFragment fragment = new FaqFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}
	

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        
    	View v = inflater.inflate(R.layout.faq_fragment, container, false);
        
    	expListView = (ExpandableListView) v.findViewById(R.id.lvExp);
    	    	listDataHeader = new ArrayList<String>();
		listDataChild = new HashMap<String, List<String>>();
		

		fatchFaq();
    	listAdapter = new ExpandableListAdapter(v.getContext(), listDataHeader, listDataChild);
    	
    	expListView.setAdapter(listAdapter);
    	
    	expListView.setOnGroupExpandListener(new OnGroupExpandListener() {

    	    @Override
    	    public void onGroupExpand(int groupPosition) {
    	            if (lastGroup != -1
    	                    && groupPosition != lastGroup) {
    	            	expListView.collapseGroup(lastGroup);
    	            }
    	            lastGroup = groupPosition;
    	    }
		});    	
    	
        return v; 
    }
    
    
    
    public void fatchFaq() {
    	
    	addElement("Da dove arriva l’acqua del rubinetto delle case milanesi?","Dalla falda acquifera, cioè dal sottosuolo. L’acqua viene prelevata attraverso 587 pozzi di profondità variabile (tra i 30 e i 120 metri) e viene inviata alle centrali, dove è filtrata, trattata e resa potabile attraverso sistemi tecnologici molto avanzati. Da qui viene distribuita ai cittadini attraverso i 2295 km di tubazioni di rete idrica. Le centrali di potabilizzazione attive sono 28 e sono dislocate su tutto il territorio cittadino.");
    	addElement("Quanto costa l’acqua a Milano?","0,60 euro al metro cubo, pari a 1000 litri di acqua: il costo più basso in Italia e tra i più convenienti in Europa. Nella tariffa sono compresi i costi di erogazione dell’acqua potabile, di raccolta delle acque reflue e della depurazione.");
    	addElement("L’acqua del rubinetto è sicura?","Grazie al laboratorio di analisi dell’acquedotto e ai controlli dell’Asl, ogni anno vengono svolte 190.000 analisi chimiche e microbiologiche che assicurano e certificano la qualità dell’acqua di Milano.");
    	addElement("Dove è possibile trovare le analisi dell’acqua del rubinetto?","MM pubblica trimestralmente sui suoi siti i risultati delle analisi dell’acqua. Gli stessi dati sono diffusi attraverso le bollette. Per avere informazioni aggiornate sulla qualità dell’acqua, puoi chiedere all’amministratore del tuo stabile di esporre la bolletta nello spazio destinato alla comunicazione con i condomini. Le analisi sono reperibili anche presso Asl città di Milano servizio SIAN di via Statuto.");
    	addElement("Si può bere l’acqua quando ha odore di cloro?","L’acquedotto gestito da MM utilizza in minime quantità l’ipoclorito di sodio (comunemente detto cloro) come disinfettante allo scopo di garantire la perfetta igiene dell’acqua, dalla centrale di pompaggio fino al rubinetto. Solitamente l’odore di cloro non viene percepito ma, nel caso, basterà raccogliere l’acqua in una brocca e lasciarla decantare per qualche minuto.");
    	addElement("Se, appena aperto il rubinetto, scende acqua torbida o con una colorazione rossastra, cosa significa?","Probabilmente nello stabile sono stati fatti di recente dei lavori sulla rete interna di distribuzione oppure l’erogazione dell’acqua è stata interrotta e si è quindi formato un ristagno nei tubi. La stessa situazione può verificarsi quando il rubinetto resta chiuso per molto tempo (per le vacanze estive a causa degli ossidi di ferro rilasciati dalle pareti interne delle tubazioni di acciaio). Per eliminare questa colorazione basterà lasciar scorrere abbondantemente l’acqua, anche per una decina di minuti.");
    	addElement("Capita che l’acqua contenga tracce di sabbia. Cosa si deve fare in questo caso?","La presenza di sabbia non indica un’alterazione della qualità dell’acqua. Questi residui derivano dal calcare che si forma per la normale precipitazione degli ioni di calcio e magnesio, soprattutto quando si riscalda l’acqua per gli usi domestici. Per ristabilire un flusso trasparente è sufficiente utilizzare e tenere sempre pulito il filtro frangi-getto e per ridurne la formazione, non scaldare eccessivamente l’acqua domestica negli scaldabagni.");
    	addElement("Perché l’acqua a volte ha un colore biancastro e/o micro-bollicine?","La causa di questa opacità è l’elevata pressione dell’acqua determinata sia dagli impianti di pompaggio cittadini sia dalle autoclavi condominiali. Tale pressione è necessaria per poter servire anche i piani più alti delle abitazioni. Per avere l’acqua limpida è sufficiente aspettare pochi minuti dopo il prelievo per permettere alle micro-bollicine di evaporare naturalmente.");
    	addElement("Come mai le “vedovelle” non hanno il rubinetto? Non è uno spreco di acqua?","La quantità d’acqua erogata dalle fontanelle è irrisoria in confronto alla portata d’acqua distribuita dall’acquedotto milanese, infatti a fronte di un flusso totale istantaneo medio erogato dall’acquedotto di circa 7.500 litri/secondo, la portata dell’insieme delle fontanelle è pari a soli 10 litri circa al secondo. Inoltre il flusso d’acqua continuo delle vedovelle non è utile solo per dissetarsi, ma svolge anche l’importante funzione di mantenere l’acqua sempre in movimento, preservandone la freschezza e la buona qualità in corrispondenza delle tubazioni terminali cieche, le cosiddette “teste morte”. In più, l’interruzione del flusso determinerebbe la  stagnazione dell’acqua e contribuirebbe alla formazione di flora batterica attorno alla bocca del “drago” da cui sgorga l’acqua. Bisogna ricordare inoltre che la portata in uscita dalle fontanelle non si disperde inutilmente ma, attraverso la fognatura, raggiunge i depuratori di Milano, e viene quindi  impiegata dai consorzi agricoli per l’irrigazione dei campi a sud della città.");
    	addElement("È possibile visitare la nostra rete fognaria?","Per scoprire la Milano sotterranea basta compilare l’apposito form “Prenota una visita”. Le visite sono gratuite e disponibili sia per le scuole sia per i cittadini.");
    	addElement("È possibile visitare una centrale dell’acquedotto?","Per visitare una centrale dell’acquedotto basta compilare l’apposito form “Prenota una visita”.  Le visite sono gratuite e disponibili sia per le scuole sia per i cittadini.");
    	addElement("È consigliabile utilizzare depuratori condominiali?","La qualità dell’acqua è garantita da MM fino al contatore, poi la competenza passa al proprietario o all’amministratore di condominio. Non vige nessuna limitazione regolamentare all’installazione di depuratori domestici, direttamente al lavandino di casa, o all’ingresso del condominio. Nel caso si decida per l’utilizzo di questi apparecchi, si raccomanda di dimensionare gli apparecchi in base all’effettiva qualità dell’acqua fornita da MM e in funzione degli scopi che si vogliono conseguire. Si consiglia inoltre una corretta manutenzione, soprattutto per evitare il ristagno dell’acqua, spesso causa della formazione della flora batterica che può risultare addirittura nociva per la salute.");
    	addElement("È possibile chiedere di installare una “vedovella” nei giardini sotto casa?","Un cittadino o un’associazione può farne richiesta al Consiglio di Zona, che inoltrerà la domanda agli Uffici Arredo Urbano – Parchi e Giardini del Comune di Milano, coinvolgendo la polizia locale e MM. Dopo opportuni accertamenti da parte della Polizia municipale sulla sicurezza del luogo di collocazione e da parte di MM dal punto di vista idrologico, la fontanella verrà installata. Il servizio è gratuito.");
    	
    	/*
    	addElement("Se l’acqua del tuo rubinetto ha un forte odore di cloro …", "L’ipoclorito di sodio, meglio noto come cloro, è usato per garantire la perfetta igiene dell’acqua, dalla centrale di pompaggio fino al rubinetto. Per eliminare questo inconveniente raccogli l’acqua in una brocca e lasciala decantare per qualche minuto.");
    	addElement("Se, appena aperto il rubinetto, l’acqua è torbida o ha una colorazione rossastra …", "Il fenomeno può essere dovuto a lavori di manutenzione sulle tubazioni di rete o, più frequentemente, al ristagno dell’acqua negli impianti interni condominiali che, essendo di acciaio e spesso vecchi di alcune decine di anni, rilasciano ossidi di ferro. Per rimediare a questo inconveniente (che spesso si presenta quando da alcuni giorni non usiamo l’acqua, soprattutto d’estate) è sufficiente fare scorrere l’acqua per alcuni minuti.");
    	addElement("Se l’acqua contiene tracce di sabbia e ha intasato i filtri frangigetto …", "Le tracce di sabbia derivano dal calcare che si forma per la normale precipitazione degli ioni di calcio e magnesio, soprattutto quando si riscalda l’acqua per gli usi domestici. Per evitare questo problema è opportuno non scaldare eccessivamente l’acqua di casa e pulire periodicamente i filtri.");
    	addElement("Se l’acqua raccolta nel bicchiere risulta biancastra e piena di micro-bollicine …", "Dipende dall’elevata pressione dell’acqua determinata dagli impianti cittadini di pompaggio ma soprattutto dalle autoclavi condominiali. Tale pressione è necessaria per poter servire anche i piani più alti delle abitazioni. Basterà aspettare pochi minuti dopo il prelievo per permettere alle micro-bollicine di evaporare naturalmente.");
    	*/
    	
    	List<String> evitSprechi = new ArrayList<String>();
    	evitSprechi.add("1. controlliamo che non ci siano perdite nelle tubature o nei rubinetti");
    	evitSprechi.add("2. utilizziamo la lavatrice e la lavastoviglie solo a carico completo e possibilmente a basse temperature, anche per il risparmio energetico");
    	evitSprechi.add("3. non facciamo scorrere l’acqua della doccia mentre ci insaponiamo");
    	evitSprechi.add("4. evitiamo di lasciare l’acqua aperta mentre laviamo i denti e impariamo a usare un bicchiere");
    	evitSprechi.add("5. cerchiamo di imparare a innaffiare con l’acqua piovana, l’acqua usata per lavare frutta e verdura o l’acqua di cottura");
    	evitSprechi.add("6. teniamo sempre una bottiglia d’acqua in frigo, invece di far scorrere l’acqua per raffreddarla");
    	addElement("Evitiamo gli sprechi...", evitSprechi);
    	
    	
    	List<String> loSaiChe = new ArrayList<String>();
    	loSaiChe.add("1. per fare un bagno in vasca consumiamo mediamente fra i 120 e i 160 litri di acqua");
    	loSaiChe.add("2. per una doccia di 5 minuti consumiamo dai 75 ai 90 litri, per una doccia di 3 minuti dai 35 ai 50 litri");
    	loSaiChe.add("3. ogni volta che tiriamo lo sciacquone usiamo 16 litri d’acqua");
    	loSaiChe.add("4. ogni volta che ci laviamo le mani consumiamo 1,4 litri");
    	loSaiChe.add("5. per lavarsi i denti lasciando scorrere l’acqua sprechiamo 30 litri, se chiudiamo il rubinetto mentre strofiniamo i denti ne usiamo solo 2 litri");
    	loSaiChe.add("6. per lavare i piatti a mano impieghiamo 20 litri  d’acqua, per un carico di lavastoviglie 40 litri");
    	loSaiChe.add("7. per un ciclo di lavatrice vengono usati dagli 80 ai 120 litri");
    	loSaiChe.add("8. un rubinetto che gocciola fa sprecare 5 litri d’acqua al giorno");
    	addElement("Lo Sai Che...", loSaiChe);
    }
    
    private void addElement(String domanda, String risposta) {
    	List<String> answers = new ArrayList<String>();
    	answers.add(risposta);
    	addElement(domanda, answers);
    }
    
    private void addElement(String domanda, List<String> answers) {
    	
    	listDataHeader.add(domanda);
    	
    	List<String> risposte = new ArrayList<String>();
    	risposte.addAll(answers);
    	listDataChild.put(domanda, risposte);
    	
    }
    
}