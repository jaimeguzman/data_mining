
import java.io.*;


/**
*
* Por hacer pantalla de estadisticas
*/


public class postagger{


static String texto = "12-tone_JJ matrix_NN 1879_NNS silver_JJ dollar_NN worth_IN a_DT 2_CD z_SYM add_VB name_NN to_TO the_DT do_VBP not_RB call_VB list_NN address_NN and_CC phone_NN numbers_NNS all_DT my_PRP$ girls_NNS lyrics_NNS by_IN kiki_NN palmer_NN ancient_JJ roman_NN names_NNS aol_NN map_NN &_CC directions_NNS aol_NN systray_NN asphalt_NN cowboy_NN billboard_NN music_NN charts_NNS biracial_JJ denver_NN blank_JJ map_NN of_IN the_DT middle_JJ east_JJ boca_NN ale_NN house_NN bonethugs-n-harmony_JJ ft_NN philcollins_NNS take_VBP me_PRP home_NN lyric_NN burn_VBP free_JJ music_NN to_TO cd_NN cacner_NN astrology_NN carmans_NNS photo_NN source_NN catalytic_JJ convertor_NN catholic_JJ standard_JJ archives_NNS washington_NNP d.c._NNP cc_NN times_NNS cedar_NN rapids_VBZ library_NN certified_VBN case_NN manager_NN chanel_NN layouts_NNS channel_VBP 13_CD pbs_NNS chase_JJ charge_NN chat_NN in_IN louisiana_NN check_NN on_IN a_DT business_NN license_NN chicago_NNP sun_NN times_NNS city_NN guide_NN chicago_NNP clause_NN cleaning_NN services_NNS in_IN warminster_NN pa_NN clothing_NN department_NN stores_NNS condemned_VBN pc_NN game_NN construction_NN jobs_NNS for_IN the_DT eastern_JJ shore_NN contractors_NNS licenses_NNS crazy_JJ town_NN butterfly_NN create_VB my_PRP$ own_JJ street_NN car_NN freeware_NN cruel_JJ to_TO be_VB kind_JJ custom_NN motorcycles_NNS on_IN ebay_NN dallas_NN interacial_JJ dating_VBG dating_VBG durham_NN nc_NN digital_JJ pictures_NNS for_IN downloading_VBG ding_JJ ding_NN dong_NN download_NN dance_NN circuit_NN download_NN microsoft_NN service_NN pack_NN 2_CD downloadable_JJ rpg_NN fgcu_NN applications_NNS final_JJ fantasy_NN x_CC cheat_VB codes_NNS find_VB flash_NN fredricksburg_NN va_NN lawyer_NN free_JJ birthday_NN dog_NN clipart_JJ free_JJ dj_NN mix_NN vibes_NNS free_JJ downloads_NNS song_NN games_NNS free_JJ myspace_NN layouts_NNS fruit_NN baskets_NNS kyo_VBP free_JJ online_JJ war_NN games_NNS freegames_NNS msn_NN gallaghers_NNS pizza_NN indiana_NN gwinnett_NN scan_VB hawthorn_NN height_NN -_: saying_VBG sorry_JJ hemet_NN chrysler_NN center_NN homes_NNS in_IN melbourne_NN hpinkjet_NN printer_NN drivers_NNS i_FW want_VBP dick_NN i_FW 'm_VBP gon_VBG na_TO make_VB you_PRP proud_JJ import_NN export_NN licensing_NN information_NN in_IN love_NN with_IN a_DT stripper_NN remix_NN lyrics_NNS with_IN paul_NN wall_NN indian_JJ sitar_NN guitar_NN chords_NNS ins_NNS location_NN intel_NN training_NN kah-nee-tah_JJ resort_NN weather_NN kodak_NN easy_JJ share_NN print_NN service_NN landforms_NNS in_IN peru_NN led_VBD zepplin_NN songs_NNS lion_NN coloring_VBG pages_NNS liquor_NN buddy_NN icon_NN listen_VBP song_NN hate_VB me_PRP today_NN liviamedia_NN local_JJ telephone_NN line_NN lullabye_NN lyrics_NNS billy_VBP joel_NN lyrics_NNS for_IN genecide_NN front_NN 242_CD lyrics_NNS for_IN the_DT used_VBN lunacy_NN fringe_NN lyrics_NNS live_VBP dance_NN with_IN you_PRP lyrics_NNS summer_NN in_IN the_DT city_NN lyrics_NNS to_TO closing_VBG time_NN lyrics_NNS to_TO i_FW believe_VBP by_IN blessid_NN union_NN of_IN soul_NN lyrics_NNS to_TO minority_NN lyrics_NNS to_TO the_DT wiz_NN -_: charlie_NN smalls_NNS lyrics_NNS -_: cause_VB your_PRP$ the_DT only_RB one_CD for_IN me_PRP magic_JJ dvd_NN ripper_NN 3.0_CD serial_NN man_NN stuck_VBN on_IN island_NN screensaver_NN map_NN of_IN roger_NN ar_NN map_NN of_IN the_DT south_NN of_IN france_NN mazda_NN rx8_NN photo_NN microsoft_NN office_NN beta_NN mobile_JJ gaming_NN msyace_NN my_PRP$ space_NN wallpapers_NNS myspace_JJ custom_NN backgrounds_NNS myspace_VBP kiss_NN comments_NNS ";


static String[] posTaggerTags = {"_CC", "_CD", "_DT", "_EX", "_FW", "_IN", "_JJ", "_JJR", "_JJS", "_LS", "_MD", "_NN", "_NNS", "_NNP", "_NNPS", "_PDT", "_POS", "_PRP", "_PRP$", "_RB", "_RBR", "_RBS", "_RP", "_SYM", "_TO", "_UH", "_VB", "_VBD", "_VBG", "_VBN", "_VBP", "_VBZ", "_WDT", "_WP", "_WP$", "_WRB" };


	public static void main (String args[]){



		System.out.println(  "HOLA MUND" );

		String arrayAux[] = texto.split(" ");

//		System.out.println(  texto ) ;
//
		for (int i =0; i<arrayAux.length; i++  ){


			//System.out.println( arrayAux[i] );

			String stringIterado = arrayAux[i];

			if( stringIterado.endsWith( "_JJ" )  == true ){ 

			//System.out.println( "EXITO" );
			System.out.println( arrayAux[i] );

			}





		}


		System.out.println( "conteoPatron :::" + conteoPatron(texto, "_JJ" ) );


	}

	public static int conteoPatron(String cadena, String patron){

		int count = 0, start = 0, len = patron.length();
			
		while((start = cadena.indexOf(patron, start+=len)) > -1) count++;

		return count;
	}




}


