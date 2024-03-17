package com.brendondias.game.client.beans;

import com.brendondias.game.client.controllers.*;
import com.brendondias.game.client.dtos.*;
import com.brendondias.game.client.entities.clans.Clan;
import com.brendondias.game.client.entities.classifications.NinjaClassification;
import com.brendondias.game.client.entities.elements.Element;
import com.brendondias.game.client.entities.ninjaranks.NinjaRank;
import com.brendondias.game.client.entities.ninjas.Ninja;
import com.brendondias.game.client.entities.skillTypes.SkillType;
import com.brendondias.game.client.entities.skillranks.SkillRank;
import com.brendondias.game.client.entities.skills.Skill;
import com.brendondias.game.client.entities.villages.Village;
import com.brendondias.game.client.util.AssetNames;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import lombok.Data;

import static com.brendondias.game.client.util.AssetNames.ClanIcons.*;
import static com.brendondias.game.client.util.AssetNames.ElementIcons.*;
import static com.brendondias.game.client.util.AssetNames.NinjaIcons.CLASSIC_NARUTO;
import static com.brendondias.game.client.util.AssetNames.NinjaIcons.CLASSIC_SASUKE;
import static com.brendondias.game.client.util.AssetNames.SkillIcons.GOUKAKYOU_NO_JUTSU;
import static com.brendondias.game.client.util.Descriptions.ClansDescriptions.*;
import static com.brendondias.game.client.util.Descriptions.ClassificationsDescriptions.*;
import static com.brendondias.game.client.util.Descriptions.ElementsDescriptions.*;
import static com.brendondias.game.client.util.Descriptions.NinjaRankDescriptions.*;
import static com.brendondias.game.client.util.Descriptions.SkillRankDescriptions.*;

@Singleton
@Data
public class AppStart {

    @Inject
    ClanController clanController;

    @Inject
    NinjaClassificationController ninjaClassificationController;

    @Inject
    ElementController elementController;

    @Inject
    NinjaController ninjaController;

    @Inject
    NinjaRankController ninjaRankController;

    @Inject
    SkillController skillController;

    @Inject
    SkillRankController skillRankController;

    @Inject
    SkillTypeController skillTypeController;

    @Inject
    VillageController villageController;

    private Clan createdClan;

    private NinjaClassification createdNinjaClassification;

    private Element createdElements;

    private NinjaRank createdNinjaRank;

    private SkillRank createdSkillRank;

    private SkillType createdSkillType;

    private Village createdVillage;

    private Skill createdSkill;

    private Ninja createdNinja;



    void onStart(@Observes StartupEvent ev){
        createClans();
        createClassifications();
        createElements();
        createNinjaRank();
        createSkillRank();
        createSkillType();
        createVillage();
        createSkill();
        createNinja();
    }



    private void createClans() {
        Clan uchiha = new Clan(new ClanDTO(UCHIHA_ICON,"Uchiha", UCHIHA_DESCRIPTION,0.1f));
        clanController.createClan(uchiha);

        Clan uzumaki = new Clan(new ClanDTO(UZUMAKI_ICON,"Uzumaki", UZUMAKI_DESCRIPTION,0.1f));
        clanController.createClan(uzumaki);

        Clan sarutobi = new Clan(new ClanDTO(SARUTOBI_ICON,"Sarutobi", SARUTOBI_DESCRIPTION,0.1f));
        clanController.createClan(sarutobi);

        Clan akimichi = new Clan(new ClanDTO(AKIMICHI_ICON,"Akimichi", AKIMICHI_DESCRIPTION,0.1f));
        clanController.createClan(akimichi);

        Clan hyuuga = new Clan(new ClanDTO(HYUUGA_ICON,"Hyuuga", HYUUGA_DESCRIPTION,0.1f));
        clanController.createClan(hyuuga);

        Clan yamanaka = new Clan(new ClanDTO(YAMANAKA_ICON,"Yamanaka", YAMANAKA_DESCRIPTION,0.1f));
        clanController.createClan(yamanaka);

        Clan inuzuka = new Clan(new ClanDTO(INUZUKA_ICON,"Inuzuka", INUZUKA_DESCRIPTION,0.1f));
        clanController.createClan(inuzuka);

        Clan nara = new Clan(new ClanDTO(NARA_ICON,"Nara", NARA_DESCRIPTION,0.1f));
        clanController.createClan(nara);

        Clan aburame = new Clan(new ClanDTO(ABURAME_ICON,"Aburame", ABURAME_DESCRIPTION,0.1f));
        clanController.createClan(aburame);



    }

    private void createClassifications() {
        NinjaClassification academyStudent = new NinjaClassification( new ClassificationDTO("Estudante da Academia",ACADEMY_STUDENT_DESCRIPTION,0.1f));
        ninjaClassificationController.createNinjaClassification(academyStudent);

        NinjaClassification genin = new NinjaClassification( new ClassificationDTO("Genin",GENIN_DESCRIPTION,0.2f));
        ninjaClassificationController.createNinjaClassification(genin);

        NinjaClassification chunnin = new NinjaClassification( new ClassificationDTO("Chunnin",CHUNIN_DESCRIPTION,0.3f));
        ninjaClassificationController.createNinjaClassification(chunnin);

        NinjaClassification jounin = new NinjaClassification( new ClassificationDTO("Jounin",JOUNIN_DESCRIPTION,0.4f));
        ninjaClassificationController.createNinjaClassification(jounin);

        NinjaClassification anbu = new NinjaClassification( new ClassificationDTO("Anbu",ANBU_DESCRIPTION,0.5f));
        ninjaClassificationController.createNinjaClassification(anbu);

        NinjaClassification sannin = new NinjaClassification( new ClassificationDTO("Sannin",SANNIN_DESCRIPTION,0.8f));
        ninjaClassificationController.createNinjaClassification(sannin);

        NinjaClassification kage = new NinjaClassification( new ClassificationDTO("Kage",KAGE_DESCRIPTION,0.9f));
        ninjaClassificationController.createNinjaClassification(kage);
    }

    private void createElements() {
        Element suiton = new Element(new ElementDTO(SUITON_ICON,"Suiton",SUITON_DESCRIPTION));//1
        elementController.createElement(suiton);

        Element doton = new Element(new ElementDTO(DOTON_ICON,"Doton",DOTON_DESCRIPTION));//2
        elementController.createElement(doton);

        Element katon = new Element(new ElementDTO(KATON_ICON,"Katon",KATON_DESCRIPTION));//3
        elementController.createElement(katon);

        Element fuuton = new Element(new ElementDTO(FUUTON_ICON,"Fuuton",FUUTON_DESCRIPTION));//4
        elementController.createElement(fuuton);

        Element raiton = new Element(new ElementDTO(RAITON_ICON,"Raiton",RAITON_DESCRIPTION));//5
        elementController.createElement(raiton);
    }

    private void createNinjaRank() {
        NinjaRank ninjaRankE = new NinjaRank(new NinjaRankDTO("Rank E", NINJA_RANK_E_DESCRIPTION,0.1f));
        ninjaRankController.createNinjaRank(ninjaRankE);

        NinjaRank ninjaRankD = new NinjaRank(new NinjaRankDTO("Rank D", NINJA_RANK_D_DESCRIPTION,0.2f));
        ninjaRankController.createNinjaRank(ninjaRankD);

        NinjaRank ninjaRankC = new NinjaRank(new NinjaRankDTO("Rank C", NINJA_RANK_C_DESCRIPTION,0.3f));
        ninjaRankController.createNinjaRank(ninjaRankC);

        NinjaRank ninjaRankB = new NinjaRank(new NinjaRankDTO("Rank B", NINJA_RANK_B_DESCRIPTION,0.4f));
        ninjaRankController.createNinjaRank(ninjaRankB);

        NinjaRank ninjaRankA = new NinjaRank(new NinjaRankDTO("Rank A", NINJA_RANK_A_DESCRIPTION,0.5f));
        ninjaRankController.createNinjaRank(ninjaRankA);

        NinjaRank ninjaRankS = new NinjaRank(new NinjaRankDTO("Rank S", NINJA_RANK_S_DESCRIPTION,0.8f));
        ninjaRankController.createNinjaRank(ninjaRankS);

        NinjaRank ninjaRankSS = new NinjaRank(new NinjaRankDTO("Rank SS", NINJA_RANK_SS_DESCRIPTION,1f));
        ninjaRankController.createNinjaRank(ninjaRankSS);

    }

    private void createSkillRank() {
        SkillRank skillRankE = new SkillRank(new SkillRankDTO("Rank E",SKILL_RANK_E_DESCRIPTION,0.2f));
        skillRankController.createSkillRank(skillRankE);

        SkillRank skillRankD = new SkillRank(new SkillRankDTO("Rank D",SKILL_RANK_D_DESCRIPTION,0.4f));
        skillRankController.createSkillRank(skillRankD);

        SkillRank skillRankC = new SkillRank(new SkillRankDTO("Rank C",SKILL_RANK_C_DESCRIPTION,0.6f));
        skillRankController.createSkillRank(skillRankC);

        SkillRank skillRankB = new SkillRank(new SkillRankDTO("Rank B",SKILL_RANK_B_DESCRIPTION,0.8f));
        skillRankController.createSkillRank(skillRankB);

        SkillRank skillRankA = new SkillRank(new SkillRankDTO("Rank A",SKILL_RANK_A_DESCRIPTION,1f));
        skillRankController.createSkillRank(skillRankA);

        SkillRank skillRankS = new SkillRank(new SkillRankDTO("Rank S",SKILL_RANK_S_DESCRIPTION,1.2f));
        skillRankController.createSkillRank(skillRankS);

        SkillRank skillRankSS = new SkillRank(new SkillRankDTO("Rank SS",SKILL_RANK_SS_DESCRIPTION,1.4f));
        skillRankController.createSkillRank(skillRankSS);


    }

    private void createSkillType() {

        SkillType taijutsu = new SkillType(new SkillTypeDTO("Taijutsu","Tecnicas de Corpo a corpo"));

        SkillType ninjutsu = new SkillType(new SkillTypeDTO("Ninjutsu","Jutsus chakra ofensiva"));

        SkillType fuuinjutsu = new SkillType(new SkillTypeDTO("Fuuinjutsu","Jutsus de Selamento"));

        SkillType senjutsu = new SkillType(new SkillTypeDTO("Senjutsu","Jutsus de chakra da natureza"));

        SkillType doujutsu = new SkillType(new SkillTypeDTO("Doujutsu","Jutsus de técnica ocular"));

        SkillType kenjutsu = new SkillType(new SkillTypeDTO("Kenjutsu","Jutsus de Espada"));

        SkillType genjutsu = new SkillType(new SkillTypeDTO("Genjutsu","Jutsus de Ilusão"));

        SkillType iryoNinjutsu = new SkillType(new SkillTypeDTO("Iryo Ninjutsu","Jutsus de Cura"));

        SkillType kinjutsu = new SkillType(new SkillTypeDTO("Kinjutsu","Jutsus proibidos"));

        SkillType juinjutsu = new SkillType(new SkillTypeDTO("Juinjutsu","Jutsus de Selo Amaldiçoado"));

        SkillType kugutsujutsu = new SkillType(new SkillTypeDTO("Kugutsujutsu","Jutsus de marionete"));



        skillTypeController.createSkillType(taijutsu);
        skillTypeController.createSkillType(ninjutsu);
        skillTypeController.createSkillType(fuuinjutsu);
        skillTypeController.createSkillType(senjutsu);
        skillTypeController.createSkillType(doujutsu);
        skillTypeController.createSkillType(kenjutsu);
        skillTypeController.createSkillType(genjutsu);
        skillTypeController.createSkillType(iryoNinjutsu);
        skillTypeController.createSkillType(kinjutsu);
        skillTypeController.createSkillType(juinjutsu);
        skillTypeController.createSkillType(kugutsujutsu);

    }

    private void createVillage() {
        Village konoha = new Village(new VillageDTO("undefined", "Konohagakure no Sato", "Aldeia da folha", 0.1f));
        villageController.createVillage(konoha);

        Village suna = new Village(new VillageDTO("undefined", "Sunagakure no Sato", "Aldeia da areia", 0.1f));
        villageController.createVillage(suna);

        Village iwa = new Village(new VillageDTO("undefined", "Iwagakure no Sato", "Aldeia da pedra", 0.1f));
        villageController.createVillage(iwa);

        Village kumo = new Village(new VillageDTO("undefined", "Kumogakure no Sato", "Aldeia da nuvem", 0.1f));
        villageController.createVillage(kumo);

        Village kiri = new Village(new VillageDTO("undefined", "Kirigakure no Sato", "Aldeia da névoa", 0.1f));
        villageController.createVillage(kiri);

        Village aka = new Village(new VillageDTO("undefined", "Akatsuki", "Organização Akatsuki", 0.1f));
        villageController.createVillage(aka);
    }

    private void createSkill() {
        Skill GOUKAKYOU_NO_JUTSU = new Skill(new SkillDTO(AssetNames.SkillIcons.GOUKAKYOU_NO_JUTSU, "Katon: Goukakyou no jutsu","Jutsu bola de fogo."));
        GOUKAKYOU_NO_JUTSU.setRank(skillRankController.getSkillRankService().findSkillRankById(1L));
        GOUKAKYOU_NO_JUTSU.setType(skillTypeController.getSkillTypeService().findSkillTypeById(1L));
        GOUKAKYOU_NO_JUTSU.getElementList().add(elementController.getElementService().findElementById(3L));
        skillController.createSkill(GOUKAKYOU_NO_JUTSU);

        Skill RASENGAN = new Skill(new SkillDTO(AssetNames.SkillIcons.RASENGAN, "Rasengan","Rasengan"));
        RASENGAN.setRank(skillRankController.getSkillRankService().findSkillRankById(1L));
        RASENGAN.setType(skillTypeController.getSkillTypeService().findSkillTypeById(1L));
        skillController.createSkill(RASENGAN);

        Skill CHIDORI = new Skill(new SkillDTO(AssetNames.SkillIcons.CHIDORI, "Raiton: Chidori","Chidori"));
        CHIDORI.setRank(skillRankController.getSkillRankService().findSkillRankById(1L));
        CHIDORI.setType(skillTypeController.getSkillTypeService().findSkillTypeById(1L));
        CHIDORI.getElementList().add(elementController.getElementService().findElementById(5L));
        skillController.createSkill(CHIDORI);
    }

    private void createNinja() {
        createSasuke();
        createNaruto();
    }

    private void createSasuke(){
        Ninja sasuke = new Ninja(new NinjaDTO(
                CLASSIC_SASUKE,
                "Uchiha Sasuke - Clássico",
                150,//hp
                150,//chakra
                150,//energia
                10,//nin
                10,//tai
                10,//gen
                10,//buki
                10,//str
                10,//agi
                10,//chakraControl
                10,//velo
                10,//vit
                10//resist
        ));
        sasuke.setNinjaClan(clanController.getClanService().findClanById(1L));
        sasuke.setNinjaClassification(ninjaClassificationController.getClassificationService().findNinjaClassificationById(2L));
        sasuke.setNinjaVillage(villageController.getVillageService().findVillageById(1L));
        sasuke.setNinjaRank(ninjaRankController.getNinjaRankService().findNinjaRankById(1L));
        sasuke.getElementList().add(elementController.getElementService().findElementById(5L));
        sasuke.getSkillList().add(skillController.getSkillService().findSkillById(1L));
        sasuke.getSkillList().add(skillController.getSkillService().findSkillById(2L));
        sasuke.getSkillList().add(skillController.getSkillService().findSkillById(3L));
        sasuke.getSkillList().add(skillController.getSkillService().findSkillById(2L));
        ninjaController.createNinja(sasuke);
    }

    private void createNaruto(){
        Ninja naruto = new Ninja(new NinjaDTO(
                CLASSIC_NARUTO,
                "Uzumaki Naruto - Clássico",
                150,//hp
                150,//chakra
                150,//energia
                10,//nin
                10,//tai
                10,//gen
                10,//buki
                10,//str
                10,//agi
                10,//chakraControl
                10,//velo
                10,//vit
                10//resist
        ));
        naruto.setNinjaClan(clanController.getClanService().findClanById(2L));
        naruto.setNinjaClassification(ninjaClassificationController.getClassificationService().findNinjaClassificationById(2L));
        naruto.setNinjaVillage(villageController.getVillageService().findVillageById(1L));
        naruto.setNinjaRank(ninjaRankController.getNinjaRankService().findNinjaRankById(1L));
        naruto.getElementList().add(elementController.getElementService().findElementById(4L));
        naruto.getSkillList().add(skillController.getSkillService().findSkillById(3L));
        naruto.getSkillList().add(skillController.getSkillService().findSkillById(3L));
        naruto.getSkillList().add(skillController.getSkillService().findSkillById(3L));
        naruto.getSkillList().add(skillController.getSkillService().findSkillById(3L));
        ninjaController.createNinja(naruto);

        System.out.println(ninjaController.getNinjaService().findNinjaById(1L).getNinjaClan().getClanDescription());
    }

}
