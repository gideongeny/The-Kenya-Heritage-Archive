package com.kenya.heritage.archive.data.util

import com.kenya.heritage.archive.data.model.*

object HistoricalSeeder {

    fun getDeepHeritageStitch(): List<HistoricalArtifact> = buildList {
        addAll(preColonialEpoch())
        addAll(colonialEpoch())
        addAll(earlyColonialEpoch())
        addAll(lateColonialEpoch())
        addAll(independenceEra())
        addAll(modernKenyaEra())
        addAll(futureAmbitions())
    }

    // ─────────────────────────────────────────────────────────────
    // PRE-COLONIAL (1000–1899)
    // ─────────────────────────────────────────────────────────────
    private fun preColonialEpoch() = listOf(
        artifact(
            id = "swahili_golden_age_1100",
            title = "The Swahili Coast: A Global Beacon",
            year = 1100,
            period = "11th – 15th Century",
            epoch = "Pre-Colonial Statehood",
            banner = GitHubAssetResolver.imageForYear(1100),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1100, it) },
            decade = "The 11th century saw the coastal city-states of Mombasa, Lamu, Malindi and Pate emerge as powerhouses of global trade. Arab, Persian, Indian, and Chinese merchants anchored in our harbours, exchanging silks and porcelain for our ivory, gold and iron.",
            narrative = """
                Long before the first European sails appeared on our horizon, the coast of Kenya was already a global center of sophistication, wealth, and faith. From Lamu to Malindi, our ancestors built stone cities that rivaled those of the Mediterranean.
                
                They were the masters of the monsoon winds, navigating the Indian Ocean with dhows that carried ivory, gold, and iron to the far reaches of China and India. This was the era of the Swahili Golden Age — a time when our shores were a melting pot of Bantu roots and Eastern influences, birthing a language and a culture that would become the heartbeat of East Africa.
            """.trimIndent(),
            foreign = "The Swahili culture is a unique blend of African (Bantu) roots and centuries of interaction with Arab, Persian, and Indian traders.",
            significant = "The city of Gedi (Gede) near Malindi was flourishing — a sophisticated stone-walled city with running water.",
            fun_ = "🤯 Fun Fact: Chinese porcelain shards found at Gedi ruins confirm direct trade with the Ming Dynasty!"
        ),
        artifact(
            id = "ibn_battuta_1331",
            title = "Ibn Battuta Visits Mombasa",
            year = 1331,
            period = "14th Century",
            epoch = "Pre-Colonial Statehood",
            banner = GitHubAssetResolver.imageForYear(1330),
            images = (0..3).map { GitHubAssetResolver.imageForYear(1330, it) },
            decade = "In 1331, the legendary Moroccan explorer Ibn Battuta arrived in Mombasa. He was stunned by the beauty and religious devotion of its people, describing it as a city of 'fine buildings and large mosques'.",
            narrative = """
                When Ibn Battuta anchored in Mombasa in 1331, he stepped into a world of immense culture and faith. He wrote of the 'Maani' people—deeply religious citizens who lived in high stone houses surrounded by fruit trees.
                
                This wasn't an isolated settlement; it was a jewel in a string of coastal city-states that stretched from Somalia to Mozambique. The architecture was intricate, the mosques were monuments of limestone and coral, and the people were dressed in the finest silks. 
                
                This period marks the zenith of pre-colonial coastal civilisation, where Kenya was the gateway to the African interior for the rest of the world.
            """.trimIndent(),
            foreign = "Ibn Battuta is often called the greatest traveller of the middle ages, having covered over 75,000 miles, more than Marco Polo.",
            significant = "The 1300s saw the construction of some of the most beautiful coral mosques in East Africa, many of which still stand in Lamu and Old Town Mombasa.",
            fun_ = "🤯 Fun Fact: Ibn Battuta was so impressed by the kindness of Mombasans that he stayed longer than planned just to enjoy their hospitality!"
        ),
        artifact(
            id = "interior_kingdoms_1400",
            title = "The Interior Kingdoms & Migrations",
            year = 1400,
            period = "14th – 17th Century",
            epoch = "Interior Civilisations",
            banner = GitHubAssetResolver.imageForYear(1400),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1400, it) },
            decade = "While the Swahili Coast thrived, the interior of Kenya was alive with powerful communities — the Kikuyu farming the fertile ridges, the Maasai commanding vast pasturelands, and the Luo migrating southward.",
            narrative = """
                The interior of Kenya in the 14th to 17th centuries was a dynamic world of kingdoms and migrations. The Kikuyu transformed the fertile slopes of Mount Kenya into productive agricultural heartlands.
                
                The Maasai spread across the Great Rift Valley, cultivating a martial tradition that would later make them respected world-wide. In Western Kenya, the Wanga Kingdom rose as a centralised monarchy led by the Nabongo.
            """.trimIndent(),
            foreign = "The Maasai red 'shuka' robes and beaded jewellery are symbols of Kenyan identity celebrated globally.",
            significant = "The Wanga Kingdom predated British arrival by centuries as a centralised Kenyan state.",
            fun_ = "🤯 Fun Fact: The Maasai traditionally measured wealth in cattle — some elders owned over 1,000 head!"
        ),
        artifact(
            id = "vasco_da_gama_1498",
            title = "Vasco da Gama & The Pillar of Malindi",
            year = 1498,
            period = "Late 15th Century",
            epoch = "Early Encounters",
            banner = GitHubAssetResolver.imageForYear(1490),
            images = (0..2).map { GitHubAssetResolver.imageForYear(1490, it) },
            decade = "In 1498, Portuguese explorer Vasco da Gama arrived in Malindi after being rejected by Mombasa. He was welcomed by the Sultan, setting the stage for centuries of European influence.",
            narrative = """
                The arrival of Vasco da Gama in 1498 was a turning point. Malindi, unlike its rival Mombasa, chose diplomacy. The Sultan provided da Gama with a guide, Ahmad ibn Mājid, who helped him find the route to India.
                
                In gratitude, the Portuguese built a coral pillar capped with a cross (padrão) in Malindi—a landmark that still stands today as one of the oldest European monuments in Africa.
                
                But this hospitality came at a price. It began the 'Age of the Caravels', where Portuguese naval power would soon attempt to dominate the Indian Ocean and the beautiful Kenyan coast.
            """.trimIndent(),
            foreign = "The Vasco da Gama Pillar in Malindi is a major tourist site and a symbol of early Kenya-Portugal relations.",
            significant = "This encounter established Malindi as a key strategic ally for the Portuguese for over a century.",
            fun_ = "🤯 Fun Fact: The original pillar was actually placed near the Sultan's palace, but was moved to its current location on the cliffside in the 16th century!"
        ),
        artifact(
            id = "fort_jesus_1593",
            title = "The Sentinel: Building Fort Jesus",
            year = 1593,
            period = "16th Century",
            epoch = "The Age of Resistance",
            banner = GitHubAssetResolver.imageForYear(1590),
            images = (0..3).map { GitHubAssetResolver.imageForYear(1590, it) },
            decade = "In 1593, the Portuguese completed Fort Jesus in Mombasa. Built to secure their spice routes, this massive coral fortress would become the bloodiest battlefield in Kenyan coastal history.",
            narrative = """
                Fort Jesus is an architectural masterpiece of the Italian Renaissance, but its purpose was grim: dominance. Located on Mombasa Island, it gave the Portuguese a 'God's eye view' of the harbor.
                
                For over a century, the fortress was the center of power on the East African coast. It changed hands (and flags) nine times, witness to countless sieges and heroic stand-offs by the people of Mombasa.
                
                Today, the fort sleeps peacefully as a museum, but its thick walls still hold the echoes of a time when Kenya was the frontline of a global struggle between empires.
            """.trimIndent(),
            foreign = "Fort Jesus was designed by Giovanni Battista Cairati and built using local coral and slave labor.",
            significant = "UNESCO World Heritage Site since 2011, it is the most preserved 16th-century Portuguese fort in Africa.",
            fun_ = "🤯 Fun Fact: If you look at the fort from the air, it is in the shape of a man (Jesus) lying on his back!"
        ),
        artifact(
            id = "omani_conquest_1698",
            title = "The Great Siege: Fall of the Portuguese",
            year = 1698,
            period = "Late 17th Century",
            epoch = "The Age of Resistance",
            banner = GitHubAssetResolver.imageForYear(1690),
            images = (0..4).map { GitHubAssetResolver.imageForYear(1690, it) },
            decade = "In 1698, after a gruelling 33-month siege, Omani Arab forces and local Swahili allies finally captured Fort Jesus, ending nearly 200 years of Portuguese occupation.",
            narrative = """
                The Great Siege of Fort Jesus (1696-1698) is one of the most legendary stories of endurance in history. For almost three years, the skeleton-crew inside the fort held out against thousands of Omani warriors.
                
                By the end, starvation and the plague had left fewer than a dozen survivors. When the Omani finally scaled the walls, the Portuguese era was over. The 'Mazrui' dynasty rose in Mombasa, frequently defying even their Omani overlords.
                
                This era saw the coast return to its Islamic roots and trade flourish once more, as the influence of the Sultan of Zanzibar began to permeate the region.
            """.trimIndent(),
            foreign = "The Mazrui family remained a powerful political force in Mombasa for generations after the Portuguese left.",
            significant = "1698 marks the end of European dominance on the Kenyan coast until the British arrived in the 19th century.",
            fun_ = "🤯 Fun Fact: The final survivor of the siege was a brave African woman who reportedly fought alongside the soldiers until the very end!"
        ),
        artifact(
            id = "missionary_start_1844",
            title = "Krapf & The First Mission: Rabai",
            year = 1844,
            period = "19th Century",
            epoch = "Early Encounters",
            banner = GitHubAssetResolver.imageForYear(1840),
            images = (0..2).map { GitHubAssetResolver.imageForYear(1840, it) },
            decade = "In 1844, Johann Ludwig Krapf arrived in Kenya. He established the first Christian mission in Rabai and became the first European to set eyes on Mount Kenya.",
            narrative = """
                Johann Krapf didn't just bring a new faith; he brought a passion for language and exploration. He spent years in Rabai, learning Swahili and writing the first Swahili-English dictionary.
                
                When he told the world about a 'snow-capped mountain on the equator', scientists in Europe laughed and called it a fantasy. They couldn't believe snow could exist in the burning heat of Africa.
                
                Krapf's arrival marked the beginning of Western education and the first step of the missionary influence that would reshape Kenyan society over the next century.
            """.trimIndent(),
            foreign = "Rabai, near Mombasa, is home to the first church ever built in Kenya, and you can still visit Krapf's original house today.",
            significant = "The first Swahili-English dictionary was produced in Rabai, bridging the gap between two cultures.",
            fun_ = "🤯 Fun Fact: Krapf was so dedicated to his Swahili dictionary that he reportedly wrote parts of it while suffering from 12 severe bouts of malaria!"
        ),
        artifact(
            id = "ibeac_charter_1888",
            title = "The Scramble for Kenya: IBEAC Charter",
            year = 1888,
            period = "Late 19th Century",
            epoch = "Colonial Genesis",
            banner = GitHubAssetResolver.imageForYear(1880),
            images = (0..3).map { GitHubAssetResolver.imageForYear(1880, it) },
            decade = "In 1888, the Imperial British East Africa Company (IBEAC) was granted a charter. This was the start of 'Kenya' as a corporate entity before it became a colony.",
            narrative = """
                Kenya was essentially 'owned' by a trading company before the British government took over. Sir William Mackinnon and the IBEAC aimed to control trade routes from the coast to Uganda.
                
                They established several outposts and began the difficult task of 'administering' a vast land they barely understood. But the company struggled financially, unable to cope with the costs of resistance and the railway.
                
                Their charter set the stage for the formal declaration of the British East Africa Protectorate just seven years later.
            """.trimIndent(),
            foreign = "IBEAC was inspired by the British East India Company, which had previously secured British control over India.",
            significant = "1888 marks the transition from purely coastal trade to the systematic annexation of the Kenyan interior.",
            fun_ = "🤯 Fun Fact: The IBEAC had its own currency and postage stamps—making Sir William Mackinnon the 'King' of Kenya for a brief, weird corporate decade!"
        ),
        artifact(
            id = "protectorate_1895",
            title = "Declaration of the Protectorate",
            year = 1895,
            period = "June 15, 1895",
            epoch = "Colonial Genesis",
            banner = GitHubAssetResolver.imageForYear(1890),
            images = (0..4).map { GitHubAssetResolver.imageForYear(1890, it) },
            decade = "On June 1, 1895, the British government took over from the failing IBEAC. By July 1, the British East Africa Protectorate was formally declared in Mombasa.",
            narrative = """
                The transfer of power in 1895 was a quiet ceremony in Mombasa, but its consequences were seismic. Sir Arthur Hardinge became the first Commissioner.
                
                The British government was now officially in charge of the strip of land stretching from the Indian Ocean to the Great Lakes. The era of the company was over; the era of the official Colony had begun.
                
                Within months, the surveyors for the Uganda Railway would begin their work, and the landscape of 'Kenya' would be changed forever by steel and steam.
            """.trimIndent(),
            foreign = "A 'Protectorate' was a legal term used by the British to exercise control over a territory without technically annexing it as a 'Colony' yet.",
            significant = "This declaration ended centuries of Sultanate/Coastal sovereignty and placed the entire region under London's direct rule.",
            fun_ = "🤯 Fun Fact: The British 'bought' the rights to Kenya from the failing IBEAC for just £250,000 — today, that wouldn't buy a single apartment in Westlands, Nairobi!"
        ),
        artifact(
            id = "imperial_beac_1890",
            title = "The Iron Serpent Arrives: The Uganda Railway",
            year = 1896,
            period = "Late 19th – Early 20th Century",
            epoch = "Colonial Subjugation",
            banner = GitHubAssetResolver.imageForYear(1890, 5),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1890, it) },
            decade = "The 1890s brought the Imperial British East Africa Company and the controversial Uganda Railway — a steel line that transformed it forever.",
            narrative = "Built at enormous human cost with over 32,000 Indian workers. Hundreds died from disease and the Tsavo man-eating lions.",
            foreign = "The 'Lunatic Express' cost £5 million — a fortune in 1900.",
            significant = "Nairobi was founded in 1899 as a railroad supply depot.",
            fun_ = "🤯 Fun Fact: The two Tsavo lions are now on display at the Field Museum in Chicago!"
        )
    )

    private fun earlyColonialEpoch() = listOf(
        artifact(
            id = "colonial_1900",
            title = "The Edge of Empire: 1900s",
            year = 1900,
            period = "1900 - 1909",
            epoch = "Early Colonial Era",
            banner = GitHubAssetResolver.imageForYear(1900),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1900, it) },
            decade = "The turn of the century saw the British consolidate their control through the Uganda Railway, as Nairobi transformed from a swampy depot into a burgeoning colonial town.",
            narrative = "The first decade of the 1900s was a period of profound transition. Nairobi, known as 'Enkare Nyrobi' (Place of Cool Waters) by the Maasai, was becoming the administrative heart of a new empire.",
            foreign = "The name 'Nairobi' comes from the Maasai phrase 'Enkare Nyrobi', which means 'cool water'.",
            significant = "The first Legislative Council (LegCo) was established in 1907.",
            fun_ = "🤯 Fun Fact: Nairobi was almost abandoned in 1902 after a plague outbreak!"
        ),
        artifact(
            id = "colonial_1910",
            title = "A Land in Transition: 1910s",
            year = 1910,
            period = "1910 - 1919",
            epoch = "Early Colonial Era",
            banner = GitHubAssetResolver.imageForYear(1910),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1910, it) },
            decade = "The 1910s were defined by the influx of white settlers in the 'White Highlands' and the mobilization of Kenyans for World War I.",
            narrative = "During this decade, the 'White Highlands' policy was solidified. In 1914, over 150,000 Kenyans were recruited as 'Carrier Corps'.",
            foreign = "Several areas in Nairobi are still called 'Kariakor' in memory of the Carrier Corps.",
            significant = "The Carrier Corps mobilization (1914-1918) fostered a shared identity.",
            fun_ = "🤯 Fun Fact: The first motorized vehicles began appearing on Nairobi's muddy streets during this decade!"
        ),
        artifact(
            id = "colonial_1920",
            title = "The Awakening: 1920s",
            year = 1920,
            period = "1920 - 1929",
            epoch = "Organized Resistance",
            banner = GitHubAssetResolver.imageForYear(1920),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1920, it) },
            videos = listOf("An Open Air Xmas (1925).mp4"),
            decade = "The 1920s marked the birth of formal African political organizations, led by pioneers like Harry Thuku.",
            narrative = "In 1920, Kenya formally became a Colony. The 'Kipande' system was introduced. Harry Thuku formed the East African Association in 1921.",
            foreign = "The 'Kipande' was an identification document that Africans were forced to wear around their necks.",
            significant = "The Harry Thuku protests of 1922 in Nairobi were the first major urban uprising.",
            fun_ = "🤯 Fun Fact: Harry Thuku used the telegraph system to send protest messages directly to the British Parliament!"
        )
    )

    private fun lateColonialEpoch() = listOf(
        artifact(
            id = "colonial_1930",
            title = "Economic Struggle & Cultural Pride: 1930s",
            year = 1930,
            period = "1930 - 1939",
            epoch = "Organized Resistance",
            banner = GitHubAssetResolver.imageForYear(1930),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1930, it) },
            decade = "As the Great Depression hit the world, Kenyans doubled down on education and cultural preservation.",
            narrative = "The 1930s were years of economic hardship but cultural resilience. Jomo Kenyatta was in London, representing Kenyan interests.",
            foreign = "Independent schools allowed Kenyans to maintain their identity while gaining education.",
            significant = "Jomo Kenyatta published 'Facing Mount Kenya' in 1938.",
            fun_ = "🤯 Fun Fact: While in London in the 30s, Jomo Kenyatta worked as an extra in several British films!"
        ),
        artifact(
            id = "colonial_1940",
            title = "The World at War: 1940s",
            year = 1940,
            period = "1940 - 1949",
            epoch = "The Road to Freedom",
            banner = GitHubAssetResolver.imageForYear(1940),
            images = (0..5).map { GitHubAssetResolver.imageForYear(1940, it) },
            decade = "World War II saw Kenyan soldiers fighting in Burma and Ethiopia, returning home with renewed desire for freedom.",
            narrative = "Over 75,000 Kenyans served in the King’s African Rifles. Upon returning, veterans became the backbone of the independence movement.",
            foreign = "Many Kenyan veterans of WWII formed the elite leadership of the Mau Mau fighters.",
            significant = "Eliud Mathu was appointed to the Legislative Council in 1944.",
            fun_ = "🤯 Fun Fact: Kenyan soldiers in Burma were famous for their jungle navigation skills!"
        )
    )

    private fun colonialEpoch() = listOf(
        artifact(
            id = "mau_mau_struggle",
            title = "The Forest Warriors: The Mau Mau Uprising",
            year = 1952,
            period = "1952 – 1960",
            epoch = "The Road to Freedom",
            banner = GitHubAssetResolver.imageForYear(1950),
            images = (0..7).map { GitHubAssetResolver.imageForYear(1950, it) },
            videos = listOf(
                "Capture of Dedan Kimathi _ _Mau Mau_ Leader _ Kenya Land and Freedom Army (KLFA) _ October 1956.mp4",
                "Selected Originals - Mau Mau - Lari Massacre Trial (1953).mp4",
                "Amnesty offer to maumau.mp4",
                "Selected Originals - Long Live The Queen Aka Queen Elizabeth II Returns From Kenya (1952).mp4",
                "New Parliament Building In Nairobi (1954).mp4",
                "General Nicholson Visits Kenya (1953).mp4",
                "Lancashire Fusiliers In Kenya (1953).mp4",
                "Native Farming (1950-1959).mp4"
            ),
            decade = "The 1950s were Kenya's most turbulent decade — a decade of fire, sacrifice, and the sacred oath of freedom. The Mau Mau uprising shook the British Empire to its core.",
            narrative = """
                In the misty, silent depths of the Aberdare and Mount Kenya forests, a fire was lit that could never be extinguished. Our fathers and mothers, labeled 'terrorists' by an empire that had stolen their land and dignity, rose up as the Kenya Land and Freedom Army.
                
                They fought with home-made guns and the strength of their ancestors, bound by sacred oaths taken under the cover of night. The price they paid was horrific — villages burned, families torn apart, hundreds of thousands detained in brutal camps where torture was systematic.
                
                Yet every drop of blood spilled in those forests watered the seeds of freedom. The Mau Mau was not just a war; it was a testament to the unyielding Kenyan spirit. It was their sacrifice that forced the hand of history, paving the way for the flag we raise today.
            """.trimIndent(),
            foreign = "The Mau Mau (KLFA) was a pivotal armed resistance against British colonial land alienation. While militarily suppressed, it made continuation of colonial rule morally and financially impossible for Britain.",
            significant = "In October 1956, Field Marshal Dedan Kimathi — the supreme commander of Mau Mau forest fighters — was captured in the Aberdares. He was executed on February 18, 1957. He remains a national hero.",
            fun_ = "🤯 Fun Fact: Britain only officially apologised for Mau Mau torture in 2013 — 50 years after independence — and paid £20 million in compensation to over 5,000 survivors."
        )
    )

    // ─────────────────────────────────────────────────────────────
    // INDEPENDENCE ERA (1963–1989)
    // ─────────────────────────────────────────────────────────────
    private fun independenceEra() = listOf(
        artifact(
            id = "uhuru_1963",
            title = "Uhuru! Kenya's Independence",
            year = 1963,
            period = "December 12, 1963",
            epoch = "The First Republic",
            banner = GitHubAssetResolver.imageForYear(1963),
            images = listOf(
                GitHubAssetResolver.imageForYear(1963),
                GitHubAssetResolver.imageForYear(1964)
            ),
            videos = listOf("1963 _ 50 years of Independence _ Kenya History and Biographies.mp4"),
            isFeatured = true,
            decade = "The 1960s were Kenya's foundational decade — the birth of a nation. From the midnight lowering of the Union Jack to the first bold steps of an infant republic finding its voice in Africa.",
            narrative = """
                December 12, 1963. At the stroke of midnight, the Union Jack was lowered and the green, black, red and white of Kenya rose for the first time over Uhuru Gardens in Nairobi. An entire people exhaled after decades of colonial rule.
                
                Jomo Kenyatta's voice carried across the emotional crowd: 'Harambee!' — Let us all pull together. This was not just political freedom; it was the return of dignity to millions. The tears on every face were tears of a people reborn.
                
                On December 12, 1964, Kenya became a Republic. Kenyatta, once imprisoned by the British as a "leader unto darkness," became the first President of a sovereign nation. The world watched in admiration as Africa's newest star took its place among nations.
            """.trimIndent(),
            foreign = "'Harambee' is Kenya's national motto, meaning 'Let us all pull together' in Swahili. It was coined by founding President Jomo Kenyatta to embody unity and community self-help.",
            significant = "December 12, 1963 — Kenya's Independence Day. December 12, 1964 — Kenya proclaimed a Republic. Both dates are now celebrated as 'Jamhuri Day' (Republic Day).",
            fun_ = "🤯 Fun Fact: Jomo Kenyatta, Kenya's founding father, was jailed by the British in 1952 and released in 1961 — just two years before becoming the President of independent Kenya!"
        ),
        artifact(
            id = "kenya_1970s_growth",
            title = "The Decade of Building: The 1970s",
            year = 1970,
            period = "1970 – 1979",
            epoch = "The First Republic",
            banner = GitHubAssetResolver.imageForYear(1970),
            images = (1970..1978).map { GitHubAssetResolver.imageForYear(it) },
            videos = listOf(
                "Rare Raw Footage Nairobi, Kenya in 1968 Archival Film.mp4",
                "Kenya 1960s life.mp4"
            ),
            decade = "The 1970s were Kenya's decade of national construction — universities, hospitals, roads and factories sprang up across the country. Nairobi became an African metropolis, the economic hub of East Africa.",
            narrative = """
                By the early 1970s, Kenya was the envy of East Africa. A booming tourism industry, a productive agricultural sector, and a growing infrastructure network made Nairobi the regional capital of commerce and culture.
                
                The University of Nairobi was expanding. Kenya's world-beating athletes — Kipchoge Keino had won gold at the 1968 Mexico Olympics — were making the nation famous on the global stage. Coffee and tea exports were fuelling a growing economy.
                
                In 1978, Mzee Jomo Kenyatta passed away, and Daniel arap Moi ascended to power peacefully — one of Africa's rarest traditions of a smooth leadership transition. The foundation had been laid. The decade of building was complete.
            """.trimIndent(),
            foreign = "Kipchoge 'Kip' Keino, a Kenyan police officer, won gold in the 1,500m at the 1968 Olympics, defeating the heavily favoured American Jim Ryun. He launched Kenya's legendary distance-running dynasty.",
            significant = "1974: Kenya begins free primary education, a revolutionary policy that dramatically boosted literacy rates across the nation.",
            fun_ = "🤯 Fun Fact: In 1977, Kenya, Uganda and Tanzania dissolved the East African Community — a regional union — in a dispute over Uganda's Idi Amin. It was only revived in 2000!"
        ),
        artifact(
            id = "kenya_1980s",
            title = "The 1980s: Turbulence and Defiance",
            year = 1980,
            period = "1980 – 1989",
            epoch = "The Moi Era",
            banner = GitHubAssetResolver.imageForYear(1982),
            images = (1980..1989).map { GitHubAssetResolver.imageForYear(it) },
            videos = listOf("1982 _ 50 years of Independence _ Kenya History and Biographies.mp4"),
            decade = "The 1980s were Kenya's most politically charged decade before independence. A coup attempt, tightening one-party rule, and the rise of pro-democracy voices shaped a nation coming of age.",
            narrative = """
                On August 1, 1982, a group of Kenya Air Force officers launched a coup against President Moi. For several terrifying hours, Kenyans didn't know the fate of their government. Regular army troops crushed the rebellion by evening. The entire Kenya Air Force was disbanded and rebuilt from scratch.
                
                In the aftermath, Moi's government tightened its grip — Kenya became a de-jure single-party state (KANU). Opposition voices were silenced, newspapers were censored, and some activists fled into exile.
                
                Yet the spirit of defiance would not die. Lawyers, academics, and religious leaders began organising — seeds of the multiparty movement that would eventually bloom in the 1990s. Underground literature and underground radio kept the flame of democracy burning in the hearts of Kenyans.
            """.trimIndent(),
            foreign = "The 1982 coup attempt was led by Senior Private Hezekiah Ochuka, who briefly declared himself Head of State on radio. He was caught, tried and executed for treason.",
            significant = "August 1, 1982: A coup attempt by Kenya Air Force personnel is defeated within hours by loyal troops. The entire Air Force is subsequently grounded and rebuilt.",
            fun_ = "🤯 Fun Fact: During the 1982 coup attempt, a junior airman briefly broadcast on Voice of Kenya radio: 'Fellow Kenyans, the revolution has come.' By nightfall, he was in a military prison."
        )
    )

    // ─────────────────────────────────────────────────────────────
    // MODERN KENYA (1990–2026)
    // ─────────────────────────────────────────────────────────────
    private fun modernKenyaEra() = listOf(
        artifact(
            id = "multiparty_democracy_1991",
            title = "The Second Liberation: Multiparty Democracy",
            year = 1991,
            period = "1991 – 2002",
            epoch = "The Democratic Transition",
            banner = GitHubAssetResolver.imageForYear(1991),
            images = (1990..2002 step 2).map { GitHubAssetResolver.imageForYear(it) },
            videos = listOf("1991 _ 50 years of Independence _ Kenya History and Biographies.mp4"),
            decade = "The 1990s were Kenya's decade of political awakening — the fierce, courageous fight for multiparty democracy against an entrenched single-party state. It was Kenya's second liberation.",
            narrative = """
                By 1990, the winds of change were blowing across Africa. In Kenya, brave souls — lawyers, bishops, professors — stood before Moi's government demanding freedom of speech and multiparty politics. Professor Wangari Maathai, later to win the Nobel Peace Prize, was tear-gassed. Politician Kenneth Matiba suffered a stroke in detention.
                
                But they could not be stopped. In December 1991, the ruling party voted to repeal Section 2A, restoring multiparty politics. The 1992 elections, while marred by violence and irregularities, opened the floodgates.
                
                Then came December 27, 2002 — the day Kenya truly changed. Mwai Kibaki's NARC coalition swept to power, defeating KANU and ending 40 years of single-party dominance. Citizens danced in the streets of Nairobi. It was Kenya's most peaceful, most luminous democratic moment yet.
            """.trimIndent(),
            foreign = "In 2004, Wangari Maathai became the first African woman to win the Nobel Peace Prize — awarded for her environmental activism and democratic work through the Green Belt Movement she founded.",
            significant = "December 27, 2002: Mwai Kibaki wins presidential election with 62% of votes, defeating KANU's Uhuru Kenyatta. KANU's 40-year rule ends in Kenya's most celebrated democratic transition.",
            fun_ = "🤯 Fun Fact: Kibaki was rushed to hospital just days before Election Day 2002 after a road accident. He won in a wheelchair — and Kenyans celebrated so loudly the celebrations went on for three days!"
        ),
        artifact(
            id = "constitution_2010",
            title = "The New Constitution: Kenya Reborn",
            year = 2010,
            period = "2010",
            epoch = "The Democratic Republic",
            banner = GitHubAssetResolver.imageForYear(2010),
            images = listOf(GitHubAssetResolver.imageForYear(2010), GitHubAssetResolver.imageForYear(2011)),
            videos = listOf("2010 _ 50 years of Independence _ Kenya History and Biographies.mp4"),
            decade = "The 2010 Constitution was Kenya's most ambitious political achievement since independence — rewriting the rules of governance, enshrining rights, and creating devolution that took power to the grassroots.",
            narrative = """
                On August 4, 2010, Kenyans voted overwhelmingly — 67% — in favour of a new constitution that would reshape their nation. Born from the painful ashes of the 2007–2008 post-election violence that killed over 1,300 and displaced 600,000, this new constitutional order was a promise to themselves: never again.
                
                The constitution established 47 counties, each with their own elected governor and assembly — devolution that brought government closer to the people in places like Turkana, Marsabit, and Kwale that had long felt forgotten by Nairobi.
                
                It enshrined a bold Bill of Rights — the right to clean water, the right to health, the right to education. It created an independent judiciary. It limited presidential power. It was, by any measure, one of the most progressive constitutions in Africa.
            """.trimIndent(),
            foreign = "Kenya's 2010 Constitution created 47 counties — each with a directly elected Governor and County Assembly. This devolution system transferred significant resources and decision-making from Nairobi to local communities.",
            significant = "August 4, 2010: Kenyans vote 67% in favour of a progressive new constitution — one of the most forward-looking on the African continent.",
            fun_ = "🤯 Fun Fact: The 2010 constitution is so detailed that it even specifies the maximum number of Cabinet Secretaries (22) and caps the President's salary — making Kenya one of the few countries to constitutionally limit executive pay!"
        ),
        artifact(
            id = "digital_revolution_mpesa",
            title = "The Silicon Savannah: M-Pesa & The Digital Revolution",
            year = 2007,
            period = "2007 – 2020",
            epoch = "Technological Leadership",
            banner = GitHubAssetResolver.imageForYear(2007),
            images = listOf(2007, 2010, 2015, 2018).map { GitHubAssetResolver.imageForYear(it) },
            decade = "The 2000s launched Kenya as Africa's technology capital. From M-Pesa to Silicon Savannah, Kenyans showed the world that innovation has no address — and that the next global idea could come from Nairobi.",
            narrative = """
                In 2007, a quiet revolution began in the hands of millions. With the launch of M-Pesa by Safaricom, Kenya did what the rest of the world thought impossible — we bypassed traditional banking and built a financial future on our own terms.
                
                From the smallest kiosks in Turkana to the high-rise offices on Waiyaki Way, the 'Silicon Savannah' was born. By 2011, M-Pesa was processing more transactions than Western Union worldwide. Today, over 40 million transactions happen daily.
                
                iHub in Nairobi became Africa's most celebrated tech hub. Startups like BRCK, Ushahidi, and Cellulant launched globally. Kenya became the continent's tech beacon — proof that the next great idea can come from Nairobi.
            """.trimIndent(),
            foreign = "M-Pesa transformed financial inclusion in Kenya. It allows users to transfer money, pay bills, and save using a basic mobile phone — no bank account required. Today, 'kupiga M-Pesa' (to send M-Pesa) is as common in Kenya as saying 'send a text.'",
            significant = "2007: Safaricom launches M-Pesa with 1,000 agents. By 2010, it processes more transactions globally than Western Union. By 2023, it has 51 million users across Africa.",
            fun_ = "🤯 Fun Fact: In Kenya, the phrase 'Nipee M-Pesa' (Send me M-Pesa) is heard more often than 'Can I borrow cash?' — mobile money replaced physical money for most Kenyans before most Western countries had contactless payments!"
        )
    )

    // ─────────────────────────────────────────────────────────────
    // FUTURE AMBITIONS (2026+)
    // ─────────────────────────────────────────────────────────────
    private fun futureAmbitions() = listOf(
        artifact(
            id = "kenya_future_2030",
            title = "The Horizon of Ambition: Vision 2030 & Beyond",
            year = 2026,
            period = "2026 and Beyond",
            epoch = "The Future Republic",
            banner = GitHubAssetResolver.imageForYear(2026),
            images = listOf(GitHubAssetResolver.imageForYear(2024), GitHubAssetResolver.imageForYear(2026)),
            decade = "Kenya in 2026 stands at the threshold of global relevance — a young, tech-driven, green energy leader writing the next chapter of Africa's story. The best is yet to come.",
            narrative = """
                As we stand at the edge of tomorrow, the Kenyan spirit looks forward with a gaze that is both steady and bold. Our journey from the 11th-century stone cities to this modern tech hub is only the beginning.
                
                Under the banner of Vision 2030, we are building a nation that leads the world in green energy — harnessing the steam of the Rift Valley and the heat of our sun. The Olkaria geothermal fields make Kenya one of the cleanest energy economies in Africa: over 90% of our electricity from renewables.
                
                Our athletes continue to dominate the world's roads and tracks. Our writers, like Ngũgĩ wa Thiong'o, are nominated for Nobel Prizes. Our young people are building the continent's fastest-growing startup ecosystem. We are the architects of the new Africa — proud, unified, and unstoppable.
            """.trimIndent(),
            foreign = "Vision 2030 is Kenya's long-term development blueprint, aiming to transform the country into a newly industrialising, middle-income nation by 2030 through economic, social, and political transformation.",
            significant = "Kenya generates over 90% of its electricity from renewable sources — geothermal, wind, solar, and hydro — making it one of the greenest energy grids in the developing world.",
            fun_ = "🤯 Fun Fact: Kenya's Eliud Kipchoge ran a marathon in under 2 hours in Vienna in 2019 — a feat once considered physically impossible. He then broke the official world record again in 2023. Kenya still holds EVERY major marathon world record."
        )
    )

    // ─────────────────────────────────────────────────────────────
    // Helper factory
    // ─────────────────────────────────────────────────────────────
    private fun artifact(
        id: String,
        title: String,
        year: Int,
        period: String,
        epoch: String,
        banner: String,
        images: List<String>,
        narrative: String,
        foreign: String,
        decade: String,
        significant: String,
        fun_: String,
        isFeatured: Boolean = false,
        videos: List<String> = emptyList(),
        category: HistoricalCategory = HistoricalCategory.POLITICAL
    ) = HistoricalArtifact(
        id = id,
        title = title,
        year = year,
        period = period,
        historicalEpoch = epoch,
        deepNarrative = narrative,
        foreignerTips = foreign,
        decadeDescription = decade,
        significantEvent = significant,
        funFact = fun_,
        bannerImageUrl = banner,
        latitude = -1.286389,
        longitude = 36.817222,
        category = category,
        isFeatured = isFeatured,
        mediaAssets = images.map { MediaAsset(it, AssetType.IMAGE) } + 
                videos.map { MediaAsset(GitHubAssetResolver.videoUrl(it), AssetType.VIDEO) }
    )
}
