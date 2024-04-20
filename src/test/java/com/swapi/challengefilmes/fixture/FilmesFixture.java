package com.swapi.challengefilmes.fixture;

import com.swapi.challengefilmes.domain.Filmes;

public class FilmesFixture {

    public static Filmes getNewHopeFixture() {
        return Filmes.builder()
                    .titulo("A New Hope")
                    .diretor("George Lucas")
                    .produtor("Gary Kurtz, Rick McCallum")
                    .dataLancamento("1977-05-25")
                    .idLancamento(4)
                    .descricao("It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....")
                    .versao(1)
                .build();
    }

    public static Filmes getRevengeSithFixture() {
        return Filmes.builder()
                .titulo("Revenge of the Sith")
                .diretor("George Lucas")
                .produtor("Rick McCallum")
                .dataLancamento("2005-05-19")
                .idLancamento(3)
                .descricao("War! The Republic is crumbling\\r\\nunder attacks by the ruthless\\r\\nSith Lord, Count Dooku.\\r\\nThere are heroes on both sides.\\r\\nEvil is everywhere.\\r\\n\\r\\nIn a stunning move, the\\r\\nfiendish droid leader, General\\r\\nGrievous, has swept into the\\r\\nRepublic capital and kidnapped\\r\\nChancellor Palpatine, leader of\\r\\nthe Galactic Senate.\\r\\n\\r\\nAs the Separatist Droid Army\\r\\nattempts to flee the besieged\\r\\ncapital with their valuable\\r\\nhostage, two Jedi Knights lead a\\r\\ndesperate mission to rescue the\\r\\ncaptive Chancellor....")
                .versao(1)
                .build();
    }
}
