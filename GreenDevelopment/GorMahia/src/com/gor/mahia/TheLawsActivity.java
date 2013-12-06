package com.gor.mahia;

import android.app.Activity;
import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class TheLawsActivity extends Activity{

	 public static final int HDR_POS1 = 0;
    public static final int HDR_POS2 = 11;
	public static final int HDR_POS3 = 24;
	public static final int HDR_POS4 = 49;
    public static final int HDR_POS5 = 52;
	public static final int HDR_POS6 = 55;
	public static final int HDR_POS7 = 65;
    public static final int HDR_POS8 = 67;
	public static final int HDR_POS9 = 71;
	public static final int HDR_POS10 = 74;
    public static final int HDR_POS11 = 95;
	public static final int HDR_POS12 = 97;
	public static final int HDR_POS13 = 107;
    public static final int HDR_POS14 = 110;
	public static final int HDR_POS15 = 114;
	public static final int HDR_POS16 = 118;
    public static final int HDR_POS17 = 120;
	public static final int HDR_POS18 = 123;
	public static final int HDR_POS19 = 132;
    public static final int HDR_POS20 = 139;
	public static final int HDR_POS21 = 158;
	public static final int HDR_POS22 = 160;
    public static final int HDR_POS23 = 179;
    public static final int HDR_POS24 = 186;
	public static final int HDR_POS25 = 206;
	public static final int HDR_POS26 = 213;
    public static final int HDR_POS27 = 236;
	public static final int HDR_POS28 = 239;
	public static final int HDR_POS29 = 244;
    public static final int HDR_POS30 = 247;
	public static final int HDR_POS31 = 263;
	public static final int HDR_POS32 = 273;
	public static final int HDR_POS33 = 285;
	public static final int HDR_POS34 = 291;
    public static final int HDR_POS35 = 307;
	public static final int HDR_POS36 = 320;
	public static final int HDR_POS37 = 338;
    public static final int HDR_POS38 = 346;

    public static final String[] LIST = { 
    	"CONSTITUTIONAL", 
    	"The Revision of the Laws Act",
        "The Interpretation and General Provisions Act",
        "The Law Reform Commission Act", 
        "The Constitution of Kenya Review Act (Expired)",
        "The East African Community Mediation Agreement Act",
		"The Eastern and Southern African Management Institute Act",
		"The Preferential Trade Area (Implementation) Act",
		"The National Assembly Remuneration Act",
		"The National Assembly(Powers and Privileges) Act",
		"The National Assembly and Presidential Elections Act",
		
		"COURTS AND OFFICERS OF THE COURT",
		"The Judicature Act", 
		"The Appellate Jurisdiction Act", 
		"The Magistrates’ Courts Act", 
		"The Kadhis’ Courts Act",
		"The Commissioners of Assize Act", 
		"The Records Disposal Act", 
		"The Oaths and Statutory Declarations Act", 
		"The Advocates Act",
		"The Council of Legal Education Act",
		"The Notaries Public Act", 
		"The Law Society of Kenya Act", 
		"The Public Archives and Documentation Service Act",
		
		"CIVIL LAW AND PROCEDURE", 
		"The Civil Procedure Act", 
		"The Limitation of Actions Act", 
		"The Law of Contract Act",
		"The Contracts in Restraint of Trade Act",
		"The Government Contracts Act", 
		"The Law Reform Act", 
		"The Bills of Exchange Act",
		"The Chattels Transfer Act", 
		"The Partnership Act",
		"The Limited Partnerships Act",
		"The Sale of Goods Act", 
		"The Fatal Accidents Act", 
		"The The Age of Majority Act",
		"The Occupiers’ Liability Act",
		"The Cheques Act", 
		"The Defamation Act", 
		"The Law of Domicil Act",
		"The Disposal of Uncollected Goods Act", 
		"The Public Authorities Limitation Act", 
		"The Government Proceedings Act",
		"The Vexatious Proceedings Act",
		"The Debts (Summary Recovery) Act ", 
		"The Foreign Judgments (Reciprocal Enforcement) Act", 
		"The Indemnity Act",
		
		
		"BANKRUPTCY AND DEEDS OF ARRANGEMENT",
		"The Bankruptcy Act", 
		"The Deeds of Arrangement Act", 
		
		"PUBLIC ORDER AND SECURITY",
		"The Public Order Act", 
		"The Preservation of Public Security Act", 
		
		
		"CRIMINAL LAW AND PROCEDURE",
		"The Penal Code Act",
		"The Probation of Offenders Act", 
		"The Election Offences Act", 
		"The Witchcraft Act",
		"The Protection of Aircraft Act",
		"The Criminal Procedure Code Act", 
		"The Extradition (Contiguous and Foreign Countries) Act", 
		"The Extradition (Commonwealth Countries) Act ",
		"The Witness Summonses (Reciprocal Enforcement) Act",
		
		"EVIDENCE",
		"The Evidence Act",
		
		
		"POLICE", 
		"The Police Act", 
		"The Administration Police Act",
		"The Fugitive Offenders Pursuit Act",
		
		
		"PRISONS AND DETENTION OF PERSONS", 
		"The Prisons Act", 
		"The Borstal Institutions Act ",
		
		"GENERAL ADMINISTRATION",
		"The College of Arms Act", 
		"The National Flag, Emblems and Names Act", 
		"The Promissory Oaths Act",
		"The Permanent Secretary to the Treasury(Incorporation) Act",
		"The Commissions of Inquiry Act", 
		"The Fire Inquiry Act", 
		"The Public Collections Act",
		"The Registration of Persons Act",
		"The Societies Act", 
		"The Wakf Commissioners Act", 
		"The Public Holidays Act",
		"The Books and Newspapers Act",
		"The Firearms Act", 
		"The Explosives Act",
		"The Housing Act",
		"The Methylated Spirits Act", 
		"The Compounding of Potable Spirits Act", 
		"The Chief’s Authority Act",
		"The Government Accommodation Act",
		"The Betting, Lotteries and Gaming Act",
		
		"CHILDREN",
		"The Legitimacy Act", 
		
		"FAMILY LAW",
		"The Births and Deaths Registration Act", 
		"The Marriage Act", 
		"The African Christian Marriage and Divorce Act",
		"The Matrimonial Causes Act",
		"The Subordinate Courts (Separation and Maintenance) Act", 
		"The Maintenance Orders Enforcement Act", 
		"The Mohammedan Marriage and Divorce Registration Act",
		"The Mohammedan Marriage, Divorce and Succession Act",
		"The Hindu Marriage and Divorce Act", 
		
		
		"SUCCESSION—PROBATE AND ADMINISTRATION", 
		"The Law of Succession Act",
		"The Perpetuities and Accumulations Act",
		
		"TRUSTEES",
		"The Trustees(Perpetual Succession) Act", 
		"The Trustee Act", 
		"The Public Trustee Act",
		
		"NATIONALITY—IMMIGRATION",
		"The Kenya Citizenship Act", 
		"The Immigration Act", 
		"The Aliens Restriction Act",
		
		
		"DIPLOMATIC AND CONSULAR  PRIVILEGES",
		"The Privileges and Immunities Act", 
		
		"THE CIVIL SERVICE", 
		"The Service Commissions Act", 
		"The Official Secrets Act",
		
		"PENSIONS AND PROVIDENT FUNDS",
		"The Pensions Act", 
		"The Pensions(Increase) Act", 
		"The Provident Fund Act",
		"The Widows’ and Orphans’ Pensions Act",
		"The Asian Widows’ and Orphans’ Pensions Act", 
		"The Asian Officers’ Family Pensions Act", 
		"The Widows’ and Children’s Pensions Ac",
		"The Parliamentary Pensions Act",
		
		"DEFENCE",
		"The Geneva Conventions Act", 
		"The Armed Forces Act", 
		"The Kenya Regiment (Territorial Force) Act",
		"The Armed Forces (Out of Bounds Areas) Act",
		"The Protected Areas Act", 
		"The National Youth Service Act", 
		
		
		"EDUCATIONAL—CULTURAL AND SOCIAL INSTITUTIONS—ENTERTAINMENT",
		"The Kenya Literature Bureau Act", 
		"The University of  Nairobi Act", 
		"The Moi University Act",
		"The Universities Act",
		"The Kenyatta University Act", 
		"The Education Act", 
		"The Teachers Service Commission Act",
		"The Higher Education Loans Board Act",
		"Egerton University Act",
		"The McMillan Memorial Library Act",
		"The Kenya Cultural Centre Act",
		"The Kenya Scouts Act",
		"The Girl Guides Act",
		"The Kenya Broadcasting Corporation Act",
		"The Films and Stage Plays Act",
		"The Board of Adult Education Act",
		"The Kenya National Library Service Board Act",
		"The The Kenya National Examinations Council Act",
		
		"EMPLOYMENT",
		"The Industrial Training Act",
		
		"PUBLIC HEALTH AND WELFARE",
		"The Public Health Act", 
		"The Radiation Protection Act", 
		"The Pharmacy and Poisons Act",
		"The Malaria Prevention Act",
		"The Use of Poisonous Substances Act",
		"The Mental Health Act",
		"The Anatomy Act",
		"The Science and Technology Act",
		"The Kenya Society for the Blind Act",
		"The Human Tissues Act",
		"The Medical Practitioners and Dentists Act",
		"The Food, Drugs and Chemical Substances Act",
		"The Kenya Red Cross Society Act",
		"The Nurses Act",
		"The National Social Security Fund Act", 
		"The St. John Ambulance of Kenya Act",
		"The Clinical Officers (Training, Registration and Licensing) Act",
		"The Kenya Medical Training College Act",
		
		"LOCAL GOVERNMENT",
		"The Local Government Act",
		"The Valuation for Rating Act",
		"The Rating Act",
		"The Local Government Loans Act",
		"The Local Authorities Provident Fund Act",
		"TThe Local Authorities (Recovery of Possession of Property) Act",
		
		"LAND",
		"The Government Lands Act",
		"The Registration of Titles",
		"The Land Titles Act",
		"The Land Consolidation Act",
		"The Land Adjudication Act",
		"The Registration of Documents Act",
		"The Land (Group Representatives) Act", 
		"The Trust Land Act",
		"The Trusts of Land Act",
		"The Equitable Mortgages Act",
		"The Wayleaves Act",
		"The Distress for Rent Act",
		"The Trespass Act",
		"The Land Acquisition Act",
		"The Rent Restriction Act",
		"The Survey Act",
		"The Registered Land Act",
		"The Landlord and Tenant (Shops, Hotels and Catering Establishments) Act",
		"The Land Control Act",

		"MINES AND MINERALS",
		"The Mortgages (Special Provisions) Act",
		"The Mining Act",
		"The Petroleum (Exploration and Production) Act",
		"The Trading in Unwrought Precious Metals Act",
		"The Diamond Industry Protection Act",
		"The Gold Mines Development Loans Act",
		
		"AGRICULTURE", 
		"The Agriculture Act",
		"The Agricultural Produce(Export) Act",
		"The Agricultural Produce Marketing Act",
		"The Crop Production and Livestock Act",
		"The Agricultural Finance Corporation Act",
		"The Plant Protection Act",
		"The Suppression of Noxious Weeds Act",
		"The Seeds and Plant Varieties Act",
		"The Grass Fires Act",
		"The Canning Crops Act",
		"The Cereals and Sugar Finance Corporation Act",
		"The Coconut Industry Act",
		"The Coconut Preservation Act",
		"The Cotton Act",
		"The Dairy Industry Act",
		"The National Cereals and Produce Board Act",
		"The Pyrethrum Act",
		"The Sisal industry Act",
		"The Tea Act",
		"The Fertilizers and Animal Foodstuffs Act",
		"The Pest Control Products Act",
		"The Irrigation Act",
		
		
		"WATER",
		"The Maritime Zones Act",
		"The Mombasa Pipeline Board Act",
		
		"NATIONAL PARKS, GAME, FISHERIES AND TOURISM",
		"The Wildlife (Conservation and Management) Act",
		"The Fisheries Act",
		"The Tourist Industry Licensing",
		"The Kenya Tourist Development Corporation Act",
		
		"FORESTS",
		"The Forests Act",
		"The Timber Act",
		
		"WAYS AND COMMUNICATIONS",
		//a shipping
		"The Merchant Shipping Act",
		"The Marine Insurance Act",
		"The Kenya Ports Authority Act",
		"The Carriage of Goods by Sea Act",	
		//b aviation
		"The Civil Aviation Act",
		//c railways
		"The Kenya Railways Corporation Act",
		//d public roads and bridges
		"The Public Roads and Roads of Access Act",
		"The Mtwapa Bridge Act",
		"The Traffic Act",
		"The Transport Licensing Act",
		"The Insurance(Motor Vehicles Third Party Risks) Act",
		"The Streets Adoption Act",
		"The Public Roads Toll Act",
		//e inland waterways
		"The Ferries",
		//f  Posts  and Telecommunications 
		"The Kenya Posts and Telecommunications Corporation Act",
		
		"PUBLIC DEVELOPMENT AUTHORITIES AND INSTITUTIONS",
		"The Kerio Valley Development Authority Act",
		"The Lake Basin Development Authority Act",
		"The Tana and Athi Rivers Development Authority Act",
		"The Agricultural Development Corporation Act",
		"The Industrial and Commercial Development Corporation Act",
		"The State Corporations Act",
		"The Ewaso Ng’iro South River Basin Development Authority Act",
		"The Ewaso Ng’iro North River Basin Development Authority Act",
		"The Coast Development Authority Act",
		
		"GUARANTEES",
		"The Guarantee(High Commission Posts and Telecommunications Loan) (No.1) Act",
		"The Guarantee(High Commission Posts and Telecommunications Loan) (No.2) Act",
		"The Guarantee(High Commission Posts and Telecommunications Loan) (No.3) Act",
		"The Guarantee(High Commission  Railways and Harbours Loan) (No.1) Act",
		"The Guarantee(High Commission Railways and Harbours Loan) (No.2) Act",
		"The Guarantee(High Commission Railways and Harbours Loans) (Supplementary Provisions) Act ",
		"The Guarantee(High Commission Railways and Harbours Loan) (No.3) Act",
		"The Guarantee(High Commission Railways and Harbours Loan) (No.4) Act",
		"The Guarantee(High Commission Railways and Harbours Loan) (No.5) Act",
		"The Guarantee(Loans) Act",
		"The Guarantee (House Purchase) Act",
		
		"INTERNATIONAL FINANCIAL AGREEMENTS",
		"The Bretton Woods Agreements Act",
		"The International Development Association  Act",
		"The International Finance Corporation Act",
		"The International Monetary Fund Act",
		"The International Monetary Fund (Amendment of Articles) Act",
		
		"REVENUE",
		"The Kenya Revenue Authority Act",
		"The Income Tax Act",
		"The Income Tax (Allowances and Rates) Act",
		"The Customs and Excise (1st Booklet) Act",
		"The Customs and Excise ( 2nd  Booklet) Act",
		"The Telecommunications Tax Act",
		"The Refinery Throughput Tax Act",
		"The Air Passenger Tax Act",
		"The Value Added Tax Act",
		"The Hotel Accommodation Tax Act",
		"The Entertainments Tax Act",
		"The Stamp Duty Act",
		"The Local Manufacturers(Export Compensation) Act",
		"The Estate Duty Act",
		"The Second–hand Motor Vehicles Purchase Tax Act",
		
		"COMMERCIAL AND FINANCIAL INSTITUTIONS",
		"The Capital Markets Authority Act",
		"The Companies Act",
		"The Insurance Act",
		"The Kenya Re-insurance Corporation Act",
		"The Banking Act",
		"The Building Societies Act",
		"The Co-operative Societies Act",
		"The Central Bank of Kenya Act",
		"The African Development Bank Act",
		"The East African Development Bank Act",
		"The Kenya Post Office Savings Bank Act",
		"The Shelter-Afrique Act",
		
		"TRADE AND COMMERCE",
		"The Hotels and Restaurants Act",
		"The Standards Act",
		"The Registration of Business Names Act",
		"The Transfer of Businesses Act",
		"The Scrap Metal Act",
		"The Restrictive Trade Practices, Act Monopolies and Price Control",
		"The Trade Descriptions Act",
		"The Trade Marks Act",
		"The Hire Purchase Act",
		"The Telegraphic Press Messages Act",
		"The Weights and Measures Act",
		"The British Standard Portland Cement Company Limited (Bamburi Factory) Act",
		"The Export Processing Zones Act",
		"The Foreign Investments Protection Act",
		"The Trading in Prohibited Goods Act",
		"The Motor Vehicle Components and Accessories Act",
		"The Investment Disputes Convention Act",
		
		"OTHER PROFESSIONS AND OCCUPATIONS",
		"The Architects and Quantity Surveyors Act",
		"The Brokers Act",
		"The Pawnbrokers Act",
		"The Engineers Registration Act",
		"The Valuers Act",
		"The Estate Agents Act",
		"The Certified Public Secretaries of Kenya Act",
		
		"ENACTMENTS WITH NO CHAPTER NUMBERS",
		"The Sectional Properties Act",
		"The Land Disputes Tribunal Act",
		"The Non- Governmental Organizations Co-ordination Act",
		"The Coast Development Authority Act",
		"The Petroleum Development Fund Act",
		"The Consolidated Bank of Kenya Act",
		"The Carriage by Air Act",
		"The Road Maintenance Levy Fund Act",
		"The National Council for Law Reporting Act",
		"The Narcotic Drugs and psychotropic Substances (Control) Act, 1994",
		"The Arbitration Act",
		"The Physical Planner Registration Act",
		"The Auctioneers Act",
		"The Retirement Benefits Act",
		"The National Crime Research Center Act",
		"The Kenya Reinsurance Corporation",
		"The Kenya Information and  Communications Act",
		"The Postal Corporation Act",
		"The Local Authorities Transfer Fund Act",
		"The  National Hospital Insurance  Fund Act ",
		"The Community Service Orders Act",
		"The National Security Intelligence Service Act",
		"The Kenya Roads Board Act",
		"The Environmental Management and Co-ordination Act",
		"The Medical Laboratory Technicians and Technologists Act",
		"The Bukura Agricultural College Act",
		"The Central Depositories Act",
		"The Maseno University Act",
		"The Parliamentary Services Commissions Act",
		"The Children Act",
		"The Sugar Act",
		"The Industrial Property Act",
		"The Children’s Act",
		"The Coffee Act ",
		"The Sugar Act",
		"The Kenya Water Institute Act",
		"Copyright Act",
		"The Water Act",
		"Kenya Water Institute Act",
		"The Copyright Act",
		"Anti- Corruption Economic Crimes Act, 2003",
		"The Public Officer Ethics Act, 2003",
		"Constituencies Development Fund Act, 2003",
		"The Presidential Retirement Benefit Act, 2003",
		"The Public Audit Act, 2003",
		"The National Commission on Gender and Development, 2003",
		"The persons with Disabilities Act, 2003",
		"The Government Financial Management Act , 2004",
		"The Investment Promotion Act, 2004",
		"The Privatization Act, 2005",
		"The Public Procurement and Disposal Act, 2005",
		"The Forests Act, 2005",
		"The Sexual  Offences Act, 2006",
		"The Statistics Act, 2006",
		"The Kenya Maritime Authority  Act, 2006",
		"The National Museums and Heritage Act, 2006",
		"The Insurance (Amendment) Act, 2006",
		"The Energy Act , 2006",
		"The Refugees Act, 2006",
		"The HIV and AIDS Prevention and Control Act, 2006",
		"The Kenya Institute for Public Policy Research and Analysis Act, 2006",
		"The Witness Protection Act, 2006",
		"The Licensing Laws (Repeals and Amendment) Act, 2006",
		"The Masinde Muliro University of Science and Technology Act, 2006",
		"The Microfinance Act, 2006",
		"The Kenya Roads Act, 2007",
		"The Tobacco Control Act, 2007",
		"The Licensing Laws (Repeal and Amendment) Act, 2007",
		"The Statute Law (Miscellaneous Amendments) Act, 2007",
		"The Political Parties Act, 2007",
		"The Employment Act, 2007",
		"The Labour Institutions Act, 2007",
		"The Work Injury Benefits Act, 2007",
		"The Labour Relations Act, 2007",
		"The Occupational Safety and Health Act, 2007",
		"The Supplies Practitioners Management Act, 2007",
		"The Nutritionists and Dieticians Act, 2007",
		"The National Accord and Reconciliation Act, 2008",
		"The Truth, Justice and Reconciliation Act, 2008",
		"The Constitution of Kenya Review Act, 2008",
		"The Constitution of Kenya (Amendment) Act, 2008",
		"The Criminal Procedure Code (Amendment) Act, 2008",
		"The National Cohesion and Integration Act, 2008",
		"The Anti- Counterfeit Act, 2008",
		"The Anti- Counterfeit Act, 2008",
		"The Accountants  Act, 2008",
		"The International Crimes Act, 2008",
		"The Biosafety Act,  2009",
		"The Merchant shipping Act, 2009",
		"The Fiscal Management Act, 2009 ",
		"The Proceeds of Crime and Anti-Money Laundering Act, 2009",
		"The National Youth Council Act, 2009",
		"The Arbitration (Amendment) Act , 2009",
		"The Supplementary Appropriation Act, 2010",
		"The Offices Of Minister Act, 2010",
		"The Witness Protection (Amendment) Act , 2010",
		"The Alcoholic Drinks Control Act, 2010",
		"The  Commissions Of Inquiry ( Amendment) Act  , 2010 ",
		"The Prevention Of Organized Crimes Act, 2010",
		"The Supplementary Appropriation Act, 2010",
		"The Counter-Trafficking in Persons Act",
		"The Commission for the Implementation of the Constitution Act , 2010"
		};
    public static final String[] SUBTEXTS = { 
    	null,
    	"CHAPTER (Cap. No.) 1",
        "CHAPTER (Cap. No.) 2", 
        "CHAPTER (Cap. No.) 3",
        "CHAPTER (Cap. No.) 3A", 
		"CHAPTER (Cap. No.) 4",
		"CHAPTER (Cap. No.) 4A",
		"CHAPTER (Cap. No.) 4B",
		"CHAPTER (Cap. No.) 5",
		"CHAPTER (Cap. No.) 6",
		"CHAPTER (Cap. No.) 7",
		
		null,
		"CHAPTER (Cap. No.) 8",
		"CHAPTER (Cap. No.) 9",
		"CHAPTER (Cap. No.) 10",
		"CHAPTER (Cap. No.) 11",
		"CHAPTER (Cap. No.) 12",
		"CHAPTER (Cap. No.) 14",
		"CHAPTER (Cap. No.) 15",
		"CHAPTER (Cap. No.) 16",
		"CHAPTER (Cap. No.) 16A",
		"CHAPTER (Cap. No.) 17",
		"CHAPTER (Cap. No.) 18",
		"CHAPTER (Cap. No.) 19",
		
		null,
		"CHAPTER (Cap. No.) 21",
		"CHAPTER (Cap. No.) 22",
		"CHAPTER (Cap. No.) 23",
		"CHAPTER (Cap. No.) 24",
		"CHAPTER (Cap. No.) 25",
		"CHAPTER (Cap. No.) 26",
		"CHAPTER (Cap. No.) 27",
		"CHAPTER (Cap. No.) 28",
		"CHAPTER (Cap. No.) 29",
        "CHAPTER (Cap. No.) 30",
		"CHAPTER (Cap. No.) 31",
		"CHAPTER (Cap. No.) 32",
		"CHAPTER (Cap. No.) 33",
		"CHAPTER (Cap. No.) 34",
		"CHAPTER (Cap. No.) 35",
		"CHAPTER (Cap. No.) 36",
		"CHAPTER (Cap. No.) 37",
		"CHAPTER (Cap. No.) 38",
		"CHAPTER (Cap. No.) 39",
		"CHAPTER (Cap. No.) 40",
		"CHAPTER (Cap. No.) 41",
		"CHAPTER (Cap. No.) 42",
		"CHAPTER (Cap. No.) 43",
		"CHAPTER (Cap. No.) 44",
		null,
		"CHAPTER (Cap. No.) 53",
		"CHAPTER (Cap. No.) 54",
		null,
		"CHAPTER (Cap. No.) 56",
		"CHAPTER (Cap. No.) 57",
		null,
		"CHAPTER (Cap. No.) 63",
		"CHAPTER (Cap. No.) 64",
		"CHAPTER (Cap. No.) 66",
		"CHAPTER (Cap. No.) 67",
		"CHAPTER (Cap. No.) 68",
		"CHAPTER (Cap. No.) 75",
		"CHAPTER (Cap. No.) 76",
		"CHAPTER (Cap. No.) 77",
		"CHAPTER (Cap. No.) 78",
		null,
		"CHAPTER (Cap. No.) 80",
		null,
		"CHAPTER (Cap. No.) 84",
		"CHAPTER (Cap. No.) 85",
		"CHAPTER (Cap. No.) 87",
		null,
		"CHAPTER (Cap. No.) 90",
		"CHAPTER (Cap. No.) 92",
		null,
		"CHAPTER (Cap. No.) 98",
		"CHAPTER (Cap. No.) 99",
		"CHAPTER (Cap. No.) 100",
		"CHAPTER (Cap. No.) 101",
		"CHAPTER (Cap. No.) 102",
		"CHAPTER (Cap. No.) 103",
		"CHAPTER (Cap. No.) 106",
		"CHAPTER (Cap. No.) 107",
		"CHAPTER (Cap. No.) 108",
		"CHAPTER (Cap. No.) 109",
		"CHAPTER (Cap. No.) 110",
		"CHAPTER (Cap. No.) 111",
		"CHAPTER (Cap. No.) 114",
		"CHAPTER (Cap. No.) 115",
		"CHAPTER (Cap. No.) 117",
		"CHAPTER (Cap. No.) 120",
		"CHAPTER (Cap. No.) 123",
		"CHAPTER (Cap. No.) 128",
		"CHAPTER (Cap. No.) 129",
		"CHAPTER (Cap. No.) 131",
		null,
		"CHAPTER (Cap. No.) 145",
		null,
		"CHAPTER (Cap. No.) 149",
		"CHAPTER (Cap. No.) 150",
		"CHAPTER (Cap. No.) 151",
		"CHAPTER (Cap. No.) 152",
		"CHAPTER (Cap. No.) 153",
		"CHAPTER (Cap. No.) 154",
		"CHAPTER (Cap. No.) 155",
		"CHAPTER (Cap. No.) 156",
		"CHAPTER (Cap. No.) 157",
		null,
		"CHAPTER (Cap. No.) 160",
		"CHAPTER (Cap. No.) 161",
		null,
		"CHAPTER (Cap. No.) 164",
		"CHAPTER (Cap. No.) 167",
		"CHAPTER (Cap. No.) 168",
		null,
		"CHAPTER (Cap. No.) 170",
		"CHAPTER (Cap. No.) 172",
		"CHAPTER (Cap. No.) 173",
		null,
		"CHAPTER (Cap. No.) 179",
		null,
		"CHAPTER (Cap. No.) 185",
		"CHAPTER (Cap. No.) 187",
		null,
		"CHAPTER (Cap. No.) 189",
		"CHAPTER (Cap. No.) 190",
		"CHAPTER (Cap. No.) 191",
		"CHAPTER (Cap. No.) 192",
		"CHAPTER (Cap. No.) 193",
		"CHAPTER (Cap. No.) 194",
		"CHAPTER (Cap. No.) 195",
		"CHAPTER (Cap. No.) 196",
		null,
		"CHAPTER (Cap. No.) 198",
		"CHAPTER (Cap. No.) 199",
		"CHAPTER (Cap. No.) 200",
		"CHAPTER (Cap. No.) 202",
		"CHAPTER (Cap. No.) 204",
		"CHAPTER (Cap. No.) 208",
		null,
		"CHAPTER (Cap. No.) 209",
		"CHAPTER (Cap. No.) 210",
		"CHAPTER (Cap. No.) 210A",
		"CHAPTER (Cap. No.) 210B",
		"CHAPTER (Cap. No.) 210C",
		"CHAPTER (Cap. No.) 211",
		"CHAPTER (Cap. No.) 212",
		"CHAPTER (Cap. No.) 213A",
		"CHAPTER (Cap. No.) 214",
		"CHAPTER (Cap. No.) 217",
		"CHAPTER (Cap. No.) 218",
		"CHAPTER (Cap. No.) 219",
		"CHAPTER (Cap. No.) 220",
		"CHAPTER (Cap. No.) 221",
		"CHAPTER (Cap. No.) 222",
		"CHAPTER (Cap. No.) 223",
		"CHAPTER (Cap. No.) 225",
		"CHAPTER (Cap. No.) 225A",
		null,
		"CHAPTER (Cap. No.) 237",
		null,
		"CHAPTER (Cap. No.) 242",
		"CHAPTER (Cap. No.) 243",
		"CHAPTER (Cap. No.) 244",
		"CHAPTER (Cap. No.) 246",
		"CHAPTER (Cap. No.) 247",
		"CHAPTER (Cap. No.) 248",
		"CHAPTER (Cap. No.) 249",
		"CHAPTER (Cap. No.) 250",
		"CHAPTER (Cap. No.) 251",
		"CHAPTER (Cap. No.) 252",
		"CHAPTER (Cap. No.) 253",
		"CHAPTER (Cap. No.) 254",
		"CHAPTER (Cap. No.) 256",
		"CHAPTER (Cap. No.) 257",
		"CHAPTER (Cap. No.) 258",
		"CHAPTER (Cap. No.) 259",
		"CHAPTER (Cap. No.) 260",
		"CHAPTER (Cap. No.) 261",
		null,
		"CHAPTER (Cap. No.) 265",
		"CHAPTER (Cap. No.) 266",
		"CHAPTER (Cap. No.) 267",
		"CHAPTER (Cap. No.) 270",
		"CHAPTER (Cap. No.) 272",
		"CHAPTER (Cap. No.) 273",
		null,
		"CHAPTER (Cap. No.) 280",
		"CHAPTER (Cap. No.) 281",
		"CHAPTER (Cap. No.) 282",
		"CHAPTER (Cap. No.) 283",
		"CHAPTER (Cap. No.) 284",
		"CHAPTER (Cap. No.) 285",
		"CHAPTER (Cap. No.) 287",
		"CHAPTER (Cap. No.) 288",
		"CHAPTER (Cap. No.) 290",
		"CHAPTER (Cap. No.) 291",
		"CHAPTER (Cap. No.) 292",
		"CHAPTER (Cap. No.) 293",
		"CHAPTER (Cap. No.) 294",
		"CHAPTER (Cap. No.) 295",
		"CHAPTER (Cap. No.) 296",
		"CHAPTER (Cap. No.) 299",
		"CHAPTER (Cap. No.) 300",
		"CHAPTER (Cap. No.) 301",
		"CHAPTER (Cap. No.) 302",
		null,
		"CHAPTER (Cap. No.) 304",
		"CHAPTER (Cap. No.) 306",
		"CHAPTER (Cap. No.) 308",
		"CHAPTER (Cap. No.) 309",
		"CHAPTER (Cap. No.) 310",
		"CHAPTER (Cap. No.) 311",
		null,
		"CHAPTER (Cap. No.) 318",
		"CHAPTER (Cap. No.) 319",
		"CHAPTER (Cap. No.) 320",
		"CHAPTER (Cap. No.) 321",
		"CHAPTER (Cap. No.) 323",
		"CHAPTER (Cap. No.) 324",
		"CHAPTER (Cap. No.) 325",
		"CHAPTER (Cap. No.) 326",
		"CHAPTER (Cap. No.) 327",
		"CHAPTER (Cap. No.) 328",
		"CHAPTER (Cap. No.) 329",
		"CHAPTER (Cap. No.) 331",
		"CHAPTER (Cap. No.) 332",
		"CHAPTER (Cap. No.) 335",
		"CHAPTER (Cap. No.) 336",
		"CHAPTER (Cap. No.) 338",
		"CHAPTER (Cap. No.) 340",
		"CHAPTER (Cap. No.) 341",
		"CHAPTER (Cap. No.) 343",
		"CHAPTER (Cap. No.) 345",
		"CHAPTER (Cap. No.) 346",
		"CHAPTER (Cap. No.) 347",
		null,
		"CHAPTER (Cap. No.) 371",
		"CHAPTER (Cap. No.) 373",
		null,
		"CHAPTER (Cap. No.) 376",
		"CHAPTER (Cap. No.) 378",
		"CHAPTER (Cap. No.) 381",
		"CHAPTER (Cap. No.) 382",
		null,
		"CHAPTER (Cap. No.) 385",
		"CHAPTER (Cap. No.) 386",
		null,
		"CHAPTER (Cap. No.) 389",
		"CHAPTER (Cap. No.) 390",
		"CHAPTER (Cap. No.) 391",
		"CHAPTER (Cap. No.) 392",
		"CHAPTER (Cap. No.) 394",
		"CHAPTER (Cap. No.) 397",
		"CHAPTER (Cap. No.) 399",
		"CHAPTER (Cap. No.) 402",
		"CHAPTER (Cap. No.) 403",
		"CHAPTER (Cap. No.) 404",
		"CHAPTER (Cap. No.) 405",
		"CHAPTER (Cap. No.) 406",
		"CHAPTER (Cap. No.) 407",
		"CHAPTER (Cap. No.) 410",
		"CHAPTER (Cap. No.) 411",
		null,
		"CHAPTER (Cap. No.) 441",
		"CHAPTER (Cap. No.) 442",
		"CHAPTER (Cap. No.) 443",
		"CHAPTER (Cap. No.) 444",
		"CHAPTER (Cap. No.) 445",
		"CHAPTER (Cap. No.) 446",
		"CHAPTER (Cap. No.) 447",
		"CHAPTER (Cap. No.) 448",
		"CHAPTER (Cap. No.) 449",
		null,
		"CHAPTER (Cap. No.) 450",
		"CHAPTER (Cap. No.) 451",
		"CHAPTER (Cap. No.) 452",
		"CHAPTER (Cap. No.) 455",
		"CHAPTER (Cap. No.) 456",
		"CHAPTER (Cap. No.) 457",
		"CHAPTER (Cap. No.) 458",
		"CHAPTER (Cap. No.) 459",
		"CHAPTER (Cap. No.) 460",
		"CHAPTER (Cap. No.) 461",
		"CHAPTER (Cap. No.) 462",
		null,
		"CHAPTER (Cap. No.) 464",
		"CHAPTER (Cap. No.) 465",
		"CHAPTER (Cap. No.) 466",
		"CHAPTER (Cap. No.) 467",
		"CHAPTER (Cap. No.) 468",
		null,
		"CHAPTER (Cap. No.) 469",
		"CHAPTER (Cap. No.) 470",
		"CHAPTER (Cap. No.) 471",
		"CHAPTER (Cap. No.) 472",
		"CHAPTER (Cap. No.) 472(2)",
		"CHAPTER (Cap. No.) 473",
		"CHAPTER (Cap. No.) 474",
		"CHAPTER (Cap. No.) 475",
		"CHAPTER (Cap. No.) 476",
		"CHAPTER (Cap. No.) 478",
		"CHAPTER (Cap. No.) 479",
		"CHAPTER (Cap. No.) 480",
		"CHAPTER (Cap. No.) 482",
		"CHAPTER (Cap. No.) 483",
		"CHAPTER (Cap. No.) 484",
		null,
		"CHAPTER (Cap. No.) 485A",
		"CHAPTER (Cap. No.) 486",
		"CHAPTER (Cap. No.) 487",
		"CHAPTER (Cap. No.) 487A",
		"CHAPTER (Cap. No.) 488",
		"CHAPTER (Cap. No.) 489",
		"CHAPTER (Cap. No.) 490",
		"CHAPTER (Cap. No.) 491",
		"CHAPTER (Cap. No.) 492",
		"CHAPTER (Cap. No.) 493A",
		"CHAPTER (Cap. No.) 493B",
		"CHAPTER (Cap. No.) 493C",
		null,
		"CHAPTER (Cap. No.) 494",
		"CHAPTER (Cap. No.) 496",
		"CHAPTER (Cap. No.) 499",
		"CHAPTER (Cap. No.) 500",
		"CHAPTER (Cap. No.) 503",
		"CHAPTER (Cap. No.) 504",
		"CHAPTER (Cap. No.) 505",
		"CHAPTER (Cap. No.) 506",
		"CHAPTER (Cap. No.) 507",
		"CHAPTER (Cap. No.) 512",
		"CHAPTER (Cap. No.) 513",
		"CHAPTER (Cap. No.) 515",
		"CHAPTER (Cap. No.) 517",
		"CHAPTER (Cap. No.) 518",
		"CHAPTER (Cap. No.) 519",
		"CHAPTER (Cap. No.) 520",
		"CHAPTER (Cap. No.) 522",
		null,
		"CHAPTER (Cap. No.) 525",
		"CHAPTER (Cap. No.) 527",
		"CHAPTER (Cap. No.) 529",
		"CHAPTER (Cap. No.) 530",
		"CHAPTER (Cap. No.) 532",
		"CHAPTER (Cap. No.) 533",
		"CHAPTER (Cap. No.) 534",
		null,
		"CHAPTER (Cap. No.) A 21/87",
		"CHAPTER (Cap. No.) A 18/90",
		"CHAPTER (Cap. No.) A 19/90",
		"CHAPTER (Cap. No.) A 20/90",
		"CHAPTER (Cap. No.) A 4/91",
		"CHAPTER (Cap. No.) A 5/91",
		"CHAPTER (Cap. No.) A 2/93",
		"CHAPTER (Cap. No.) A 9/93",
		"CHAPTER (Cap. No.) A 11/94",
		"CHAPTER (Cap. No.) A 4/94",
		"CHAPTER (Cap. No.) A 4/95",
		"CHAPTER (Cap. No.) A 3/96",
		"CHAPTER (Cap. No.) A 5/96",
		"CHAPTER (Cap. No.) A 3/97",
		"CHAPTER (Cap. No.) A 4/97",
		"CHAPTER (Cap. No.) A 7/97",
		"CHAPTER (Cap. No.) A 2/98",
		"CHAPTER (Cap. No.) A 3/98",
		"CHAPTER (Cap. No.) A 8/98",
		"CHAPTER (Cap. No.) A 9/98",
		"CHAPTER (Cap. No.) A 10/98",
		"CHAPTER (Cap. No.) A 11/98",
		"CHAPTER (Cap. No.) A 7/99",
		"CHAPTER (Cap. No.) A 8/99",
		"CHAPTER (Cap. No.) A 10/99",
		"CHAPTER (Cap. No.) A 11/99",
		"CHAPTER (Cap. No.) A 4/00",
		"CHAPTER (Cap. No.) A 7/00",
		"CHAPTER (Cap. No.) A 10/00",
		"CHAPTER (Cap. No.) A 8/01",
		"CHAPTER (Cap. No.) A 10/01",
		"CHAPTER (Cap. No.) A 3/01",
		"CHAPTER (Cap. No.) A8/01",
		"CHAPTER (Cap. No.) A9/01",
		"CHAPTER (Cap. No.) A 10/01",
		"CHAPTER (Cap. No.) A 11/01",
		"CHAPTER (Cap. No.) A 12/01",
		"CHAPTER (Cap. No.) A8/2002",
		"CHAPTER (Cap. No.) A 11/01",
		"CHAPTER (Cap. No.) A 12/01",
		"CHAPTER (Cap. No.) A 3/03",
		"CHAPTER (Cap. No.) A 4/03",
		"CHAPTER (Cap. No.) A 10/03",
		"CHAPTER (Cap. No.) A 11/03",
		"CHAPTER (Cap. No.) A 12/03",
		"CHAPTER (Cap. No.) A 13/03",
		"CHAPTER (Cap. No.) A 14/03",
		"CHAPTER (Cap. No.) A 5/04",
		"CHAPTER (Cap. No.) A6/04",
		"CHAPTER (Cap. No.) A2/05",
		"CHAPTER (Cap. No.) A 3/05",
		"CHAPTER (Cap. No.) A 7/05",
		"CHAPTER (Cap. No.) A 3/06",
		"CHAPTER (Cap. No.) A 4/06",
		"CHAPTER (Cap. No.) A 5/06",
		"CHAPTER (Cap. No.) A 6/06",
		"CHAPTER (Cap. No.) A 11/06",
		"CHAPTER (Cap. No.) A12/06",
		"CHAPTER (Cap. No.) A13/06",
		"CHAPTER (Cap. No.) A 14/06",
		"CHAPTER (Cap. No.) A 15/06",
		"CHAPTER (Cap. No.) A 16/06",
		"CHAPTER (Cap. No.) A 17/06",
		"CHAPTER (Cap. No.) A 18/06",
		"CHAPTER (Cap. No.) A 19/06",
		"CHAPTER (Cap. No.) A 2/07",
		"CHAPTER (Cap. No.) A 3/07",
		"CHAPTER (Cap. No.) A  4/07",
		"CHAPTER (Cap. No.) A 5/07",
		"CHAPTER (Cap. No.) A 7/07",
		"CHAPTER (Cap. No.) A 10/07",
		"CHAPTER (Cap. No.) A 11/07",
		"CHAPTER (Cap. No.) A 12/07",
		"CHAPTER (Cap. No.) A 13/07",
		"CHAPTER (Cap. No.) A 14/07",
		"CHAPTER (Cap. No.) A 15/07",
		"CHAPTER (Cap. No.) A 17/07",
		"CHAPTER (Cap. No.) A 18/07",
		"CHAPTER (Cap. No.) A 4/08",
		"CHAPTER (Cap. No.) A 6/08",
		"CHAPTER (Cap. No.) A 9/08",
		"CHAPTER (Cap. No.) A 10/08",
		"CHAPTER (Cap. No.) A 11/08",
		"CHAPTER (Cap. No.) A 12/08",
		"CHAPTER (Cap. No.) A 13/08",
		"CHAPTER (Cap. No.) A 14/08",
		"CHAPTER (Cap. No.) A 15/08",
		"CHAPTER (Cap. No.) A 16/08",
		"CHAPTER (Cap. No.) A 2/09",
		"CHAPTER (Cap. No.) A 4/09",
		"CHAPTER (Cap. No.) A 5/09 ",
		"CHAPTER (Cap. No.) A 9/09",
		"CHAPTER (Cap. No.) A 10/2009",
		"CHAPTER (Cap. No.) A 11/2009",
		"CHAPTER (Cap. No.) A 1/2010",
		"CHAPTER (Cap. No.) A 3/2010 ",
		"CHAPTER (Cap. No.) A 2/2010",
		"CHAPTER (Cap. No.) A 4/2010",
		"CHAPTER (Cap. No.) A 5/2010",
		"CHAPTER (Cap. No.) A 6/2010",
		"CHAPTER (Cap. No.) A 7/2010",
		"CHAPTER (Cap. No.) A 8/2010",
		"CHAPTER (Cap. No.) A 9/2010"};

    private static final Integer LIST_HEADER = 0;
    private static final Integer LIST_ITEM = 1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.thelaws);
		
		ListView lv = (ListView)findViewById(R.id.lawListView);
        lv.setAdapter(new MyListAdapter(this));
		
	}

	 private class MyListAdapter extends BaseAdapter {
        public MyListAdapter(Context context) {
            mContext = context;
        }

        @Override
        public int getCount() {
            return LIST.length;
        }

        @Override
        public boolean areAllItemsEnabled() {
            return true;
        }

        @Override
        public boolean isEnabled(int position) {
            return true;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            String headerText = getHeader(position);
            if(headerText != null) {

                View item = convertView;
                if(convertView == null || convertView.getTag() == LIST_ITEM) {

                    item = LayoutInflater.from(mContext).inflate(
                            R.layout.lv_header_layout, parent, false);
                    item.setTag(LIST_HEADER);

                }

                TextView headerTextView = (TextView)item.findViewById(R.id.lv_list_hdr);
                headerTextView.setText(headerText);
                return item;
            }

            View item = convertView;
            if(convertView == null || convertView.getTag() == LIST_HEADER) {
                item = LayoutInflater.from(mContext).inflate(
                        R.layout.lv_layout, parent, false);
                item.setTag(LIST_ITEM);
            }

            TextView header = (TextView)item.findViewById(R.id.lv_item_header);
            header.setText(LIST[position % LIST.length]);

            TextView subtext = (TextView)item.findViewById(R.id.lv_item_subtext);
            subtext.setText(SUBTEXTS[position % SUBTEXTS.length]);

            //Set last divider in a sublist invisible
            View divider = item.findViewById(R.id.item_separator);
            if(position == HDR_POS2 -1  || position == HDR_POS3 -1
            		|| position == HDR_POS4 -1  || position == HDR_POS17 -1
            		|| position == HDR_POS5 -1  || position == HDR_POS18 -1
            		||position == HDR_POS6 -1  || position == HDR_POS19 -1
            		||position == HDR_POS7 -1  || position == HDR_POS20 -1
            		||position == HDR_POS8 -1  || position == HDR_POS21 -1
            		||position == HDR_POS9 -1  || position == HDR_POS22 -1             		||
            		position == HDR_POS10 -1  || position == HDR_POS23 -1             		||
            		position == HDR_POS11 -1  || position == HDR_POS24 -1            		||
            		position == HDR_POS12 -1  || position == HDR_POS25 -1            		||
            		position == HDR_POS13 -1  || position == HDR_POS26 -1            		||
            		position == HDR_POS14 -1  || position == HDR_POS27 -1            		||
            		position == HDR_POS15 -1  || position == HDR_POS28 -1            		||
            		position == HDR_POS16 -1  || position == HDR_POS29 -1            		||
            		position == HDR_POS30 -1  || position == HDR_POS33 -1            		||
            		position == HDR_POS31 -1  || position == HDR_POS34 -1            		||
            		position == HDR_POS32 -1  || position == HDR_POS35 -1            		||
            		position == HDR_POS36 -1  || position == HDR_POS37 -1            		||
            		position == HDR_POS38 -1  

            		) {
                divider.setVisibility(View.INVISIBLE);
            }


            return item;
        }

        private String getHeader(int position) {

            if(position == HDR_POS1  || position == HDR_POS2 || position == HDR_POS3 || position == HDR_POS4
            		
            		|| position == HDR_POS17 
            		|| position == HDR_POS5 || position == HDR_POS18 
            		||position == HDR_POS6 || position == HDR_POS19 
            		||position == HDR_POS7 || position == HDR_POS20 
            		||position == HDR_POS8 || position == HDR_POS21 
            		||position == HDR_POS9 || position == HDR_POS22            		||
            		position == HDR_POS10 || position == HDR_POS23            		||
            		position == HDR_POS11 || position == HDR_POS24           		||
            		position == HDR_POS12 || position == HDR_POS25           		||
            		position == HDR_POS13 || position == HDR_POS26           		||
            		position == HDR_POS14 || position == HDR_POS27           		||
            		position == HDR_POS15 || position == HDR_POS28           		||
            		position == HDR_POS16 || position == HDR_POS29           		||
            		position == HDR_POS30 || position == HDR_POS33           		||
            		position == HDR_POS31 || position == HDR_POS34           		||
            		position == HDR_POS32 || position == HDR_POS35           		||
            		position == HDR_POS36 || position == HDR_POS37           		||
            		position == HDR_POS38

            		
            		) {
                return LIST[position];
            }

            return null;
        }

        private final Context mContext;
    }
	
}
