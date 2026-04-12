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
            images = listOf(1100, 1200, 1300).map { GitHubAssetResolver.imageForYear(it) },
            decade = "The 11th century saw the coastal city-states of Mombasa, Lamu, Malindi and Pate emerge as powerhouses of global trade. Arab, Persian, Indian, and Chinese merchants anchored in our harbours, exchanging silks and porcelain for our ivory, gold and iron.",
            narrative = """
                Long before the first European sails appeared on our horizon, the coast of Kenya was already a global center of sophistication, wealth, and faith. From Lamu to Malindi, our ancestors built stone cities that rivaled those of the Mediterranean.
                
                They were the masters of the monsoon winds, navigating the Indian Ocean with dhows that carried ivory, gold, and iron to the far reaches of China and India. This was the era of the Swahili Golden Age — a time when our shores were a melting pot of Bantu roots and Eastern influences, birthing a language and a culture that would become the heartbeat of East Africa.
                
                Feel the pride of an era where Kenya was not a 'discovery' but a destination; a time of unparalleled architectural brilliance and scholarly pursuit. This is our foundation — built on trade, peace, and the salt of the sea.
            """.trimIndent(),
            foreign = "The Swahili culture is a unique blend of African (Bantu) roots and centuries of interaction with Arab, Persian, and Indian traders. 'Swahili' itself comes from the Arabic word 'Sawahil', meaning 'Coasts'.",
            significant = "The city of Gedi (Gede) near Malindi was flourishing — a sophisticated stone-walled city with running water, fine porcelain from China, and Islamic architecture.",
            fun_ = "🤯 Fun Fact: Chinese porcelain shards found at Gedi ruins confirm direct trade with the Ming Dynasty in the 15th century — Kenya was truly connected to the world!"
        ),
        artifact(
            id = "interior_kingdoms_1400",
            title = "The Interior Kingdoms & Migrations",
            year = 1400,
            period = "14th – 17th Century",
            epoch = "Interior Civilisations",
            banner = GitHubAssetResolver.imageForYear(1400),
            images = listOf(GitHubAssetResolver.imageForYear(1400)),
            decade = "While the Swahili Coast thrived, the interior of Kenya was alive with powerful communities — the Kikuyu farming the fertile ridges, the Maasai commanding vast pasturelands, and the Luo migrating southward from the Nile basin.",
            narrative = """
                The interior of Kenya in the 14th to 17th centuries was not empty wilderness — it was a dynamic world of kingdoms, councils and migrations. The Kikuyu, guided by their age-set system and the wisdom of the Kiama (council of elders), transformed the fertile slopes of Mount Kenya into productive agricultural heartlands.
                
                The Maasai, fierce pastoralists with a warrior culture refined over centuries, spread across the Great Rift Valley. Their morani — young warriors — cultivated a martial tradition that would later make them respected by colonialists and beloved by the world.
                
                In Western Kenya, the Wanga Kingdom rose in the 17th century, one of the few centralized monarchies in the region, led by the Nabongo. Meanwhile, the Luo, Kamba, and Somali communities were carving out their own identities across the land we call Kenya.
            """.trimIndent(),
            foreign = "The Maasai are one of the world's most recognisable cultures. Their red 'shuka' robes, beaded jewellery, and iconic jumping dances (Adumu) are symbols of Kenyan identity celebrated globally.",
            significant = "The Wanga Kingdom — Kenya's earliest centralised state — was established in Western Kenya, predating British arrival by centuries.",
            fun_ = "🤯 Fun Fact: The Maasai traditionally measured wealth in cattle. A man with 50 cattle was considered wealthy; some elders owned over 1,000 head!"
        ),
        artifact(
            id = "portuguese_resistance_1500",
            title = "Resisting the Portuguese",
            year = 1505,
            period = "16th – 17th Century",
            epoch = "The Age of Resistance",
            banner = GitHubAssetResolver.imageForYear(1505),
            images = listOf(GitHubAssetResolver.imageForYear(1505)),
            decade = "The 16th century brought violent Portuguese aggression to the Kenyan coast. For two centuries, the people of Mombasa and Malindi resisted, endured, and ultimately outlasted colonial occupation.",
            narrative = """
                In 1505, Portuguese warships bombarded and looted Mombasa, beginning a painful two-century occupation of the Kenyan coast. Fort Jesus — the imposing fortress overlooking the Old Town — was their instrument of control, completed in 1593. But it was never truly theirs.
                
                The people of Mombasa rose against their occupiers multiple times. Most famously, in 1696–1698, the Mazrui and Omani allies laid siege to Fort Jesus for a gruelling 33 months — one of the longest sieges in African history. The Portuguese garrison fell, starved and exhausted. Mombasa was free.
                
                This chapter is a story of extraordinary African resilience — of communities refusing to surrender their identity, trade routes, or dignity to foreign powers.
            """.trimIndent(),
            foreign = "Fort Jesus in Mombasa is now a UNESCO World Heritage Site. Built by the Portuguese in 1593, it changed hands 9 times over 4 centuries. You can visit it today as a museum.",
            significant = "The Omani siege of Fort Jesus (1696–98) lasted 33 months — the Portuguese garrison was ultimately defeated by starvation and disease, ending their grip on the coast.",
            fun_ = "🤯 Fun Fact: During the 3-year siege of Fort Jesus, a Portuguese relief fleet that arrived to help found everyone inside dead from plague — and sailed away without firing a shot!"
        )
    )

    private fun earlyColonialEpoch() = listOf(
        artifact(
            id = "colonial_1900",
            title = "The Edge of Empire: 1900s",
            year = 1900,
            period = "1900 - 1909",
            epoch = "Early Colonial Era",
            banner = GitHubAssetResolver.imageForDecade(1900),
            images = listOf(GitHubAssetResolver.imageForYear(1901)),
            decade = "The turn of the century saw the British consolidate their control through the Uganda Railway, as Nairobi transformed from a swampy depot into a burgeoning colonial town.",
            narrative = "The first decade of the 1900s was a period of profound transition. While the British East Africa Protectorate was formally established, the indigenous communities faced the sudden reality of land alienation. Nairobi, known as 'Enkare Nyrobi' (Place of Cool Waters) by the Maasai, was becoming the administrative heart of a new empire. This decade saw the introduction of the first currency, the Indian Rupee, and the arrival of thousands of Indian laborers who would build the backbone of the nation's infrastructure.",
            foreign = "The name 'Nairobi' comes from the Maasai phrase 'Enkare Nyrobi', which means 'cool water', referring to the Nairobi River that once flowed freely through the swampy landscape.",
            significant = "The first Legislative Council (LegCo) was established in 1907, marking the beginning of formal colonial governance in Kenya.",
            fun_ = "🤯 Fun Fact: Nairobi was almost abandoned in 1902 after a plague outbreak, but the railway was so important that the British decided to stay and build a proper town instead!"
        ),
        artifact(
            id = "colonial_1910",
            title = "A Land in Transition: 1910s",
            year = 1910,
            period = "1910 - 1919",
            epoch = "Early Colonial Era",
            banner = GitHubAssetResolver.imageForDecade(1910),
            images = listOf(GitHubAssetResolver.imageForYear(1914)),
            decade = "The 1910s were defined by the influx of white settlers in the 'White Highlands' and the mobilization of Kenyans for World War I.",
            narrative = "During this decade, the 'White Highlands' policy was solidified, pushing indigenous communities into reserves. When WWI broke out in 1914, over 150,000 Kenyans were recruited as 'Carrier Corps' to support the British campaign against the Germans in Tanganyika. Thousands died from disease and exhaustion, yet this experience exposed many Kenyans to a broader world and planted the first seeds of organized political consciousness.",
            foreign = "The Carrier Corps (Kariakor) was a labor unit where thousands of Africans served. Today, several areas in Nairobi and other towns are still called 'Kariakor' in memory of their service.",
            significant = "The Carrier Corps mobilization (1914-1918) saw the largest gathering of diverse Kenyan tribes in history up to that point, inadvertently fostering a shared identity.",
            fun_ = "🤯 Fun Fact: The first motorized vehicles began appearing on Nairobi's muddy streets during this decade, often getting stuck for days during the rainy season!"
        ),
        artifact(
            id = "colonial_1920",
            title = "The Awakening: 1920s",
            year = 1920,
            period = "1920 - 1929",
            epoch = "Organized Resistance",
            banner = GitHubAssetResolver.imageForDecade(1920),
            images = listOf(GitHubAssetResolver.imageForYear(1921)),
            decade = "The 1920s marked the birth of formal African political organizations, led by pioneers like Harry Thuku.",
            narrative = "In 1920, Kenya formally became a Colony. The 'Kipande' system was introduced to control African movement. In response, Harry Thuku formed the East African Association in 1921, demanding better wages and land rights. His arrest in 1922 led to a massive protest in Nairobi where Mary Nyanjiru famously challenged the men to act, a moment of extraordinary female leadership in our history.",
            foreign = "The 'Kipande' was an identification document that Africans were forced to wear in a metal container around their necks, a symbol of colonial suppression and control.",
            significant = "The Harry Thuku protests of 1922 in Nairobi were the first major urban uprising against colonial rule, proving that Kenyans would not stay silent.",
            fun_ = "🤯 Fun Fact: Harry Thuku used to use the telegraph system—the internet of the 1920s—to send protest messages directly to the British Parliament in London!"
        )
    )

    private fun lateColonialEpoch() = listOf(
        artifact(
            id = "colonial_1930",
            title = "Economic Struggle & Cultural Pride: 1930s",
            year = 1930,
            period = "1930 - 1939",
            epoch = "Organized Resistance",
            banner = GitHubAssetResolver.imageForDecade(1930),
            images = listOf(GitHubAssetResolver.imageForYear(1930)),
            decade = "As the Great Depression hit the world, Kenyans doubled down on education and cultural preservation through independent schools.",
            narrative = "The 1930s were years of economic hardship but cultural resilience. The Kikuyu Independent Schools Association (KISA) was formed, allowing Kenyans to educate their children without colonial or missionary control. This was a decade of intense debate over traditional practices and the role of Western influence. Meanwhile, Jomo Kenyatta was in London, representing Kenyan interests and writing 'Facing Mount Kenya', a seminal work on Gikuyu culture.",
            foreign = "Independent schools were a vital part of the resistance, allowing Kenyans to maintain their cultural identity while gaining the education needed to fight for independence.",
            significant = "Jomo Kenyatta published 'Facing Mount Kenya' in 1938, presenting Kenyan culture to the world as sophisticated and worthy of respect.",
            fun_ = "🤯 Fun Fact: While in London in the 30s, Jomo Kenyatta reportedly worked as an extra in several British films to make ends meet!"
        ),
        artifact(
            id = "colonial_1940",
            title = "The World at War & Coming Home: 1940s",
            year = 1940,
            period = "1940 - 1949",
            epoch = "The Road to Freedom",
            banner = GitHubAssetResolver.imageForDecade(1940),
            images = listOf(GitHubAssetResolver.imageForYear(1944)),
            decade = "World War II saw Kenyan soldiers fighting in Burma and Ethiopia, returning home with new skills and an unshakeable desire for freedom.",
            narrative = "The 1940s changed everything. Over 75,000 Kenyans served in the King’s African Rifles during WWII. They fought in the jungles of Burma and the mountains of Ethiopia, realizing that the 'European masters' were as human and vulnerable as anyone else. Upon returning, these veterans became the backbone of the independence movement. In 1944, the Kenya African Study Union (later KANU) was formed, marking the start of a unified political front.",
            foreign = "Many Kenyan veterans of WWII used their military experience to form the elite leadership of the Mau Mau forest fighters in the following decade.",
            significant = "The first African, Eliud Mathu, was appointed to the Legislative Council in 1944, giving Kenyans a direct (though limited) voice in government.",
            fun_ = "🤯 Fun Fact: Kenyan soldiers in Burma were famous for their ability to navigate dense jungles, often outperforming British units in traditional tracking skills!"
        )
    )

    // ─────────────────────────────────────────────────────────────
    // COLONIAL ERA (1888–1963)
    // ─────────────────────────────────────────────────────────────
    private fun colonialEpoch() = listOf(
        artifact(
            id = "imperial_beac_1890",
            title = "The Iron Serpent Arrives: The Uganda Railway",
            year = 1896,
            period = "Late 19th – Early 20th Century",
            epoch = "Colonial Subjugation",
            banner = GitHubAssetResolver.imageForYear(1896),
            images = listOf(GitHubAssetResolver.imageForYear(1895), GitHubAssetResolver.imageForYear(1900)),
            decade = "The 1890s brought the Imperial British East Africa Company and the controversial Uganda Railway — a steel line that bisected Kenya and transformed it forever, for better and for worse.",
            narrative = """
                They called it the 'Lunatic Express' — a railway stretching nearly 900 kilometres from Mombasa to Lake Victoria, built at enormous human cost. Over 32,000 workers, mostly from India, were brought to Kenya. Hundreds died from disease, harsh conditions, and the famous man-eating lions of Tsavo that stalked the workers' camps in 1898.
                
                But for the British, the railway was strategic gold — a lifeline to Uganda and control of the Nile. Nairobi, which did not exist in 1895, grew up as a railway camp and quickly became the capital of British East Africa by 1907.
                
                For Kenyans, the railway was a double-edged sword. It brought disruption, land alienation, and foreign settlers. But it also unknowingly laid the foundation for a future nation.
            """.trimIndent(),
            foreign = "The Uganda Railway — also called the 'Lunatic Line' — cost £5 million (a fortune in 1900) and the lives of hundreds of workers. The Tsavo man-eaters (two lions) reportedly killed 135 workers.",
            significant = "Nairobi was founded in 1899 as a railroad supply depot. Within a decade, it became the capital of British East Africa — the city was born from the railway.",
            fun_ = "🤯 Fun Fact: The two Tsavo lions that terrorised railway workers are now stuffed and on display at the Field Museum in Chicago, USA — far from home!"
        ),
        artifact(
            id = "mau_mau_struggle",
            title = "The Forest Warriors: The Mau Mau Uprising",
            year = 1952,
            period = "1952 – 1960",
            epoch = "The Road to Freedom",
            banner = GitHubAssetResolver.imageForYear(1952),
            images = listOf(1952, 1953, 1956, 1958).map { GitHubAssetResolver.imageForYear(it) },
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
            images = listOf(GitHubAssetResolver.imageForYear(1963), GitHubAssetResolver.imageForYear(1964)),
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
            images = listOf(1970, 1973, 1977, 1979).map { GitHubAssetResolver.imageForYear(it) },
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
            images = listOf(1980, 1982, 1986, 1989).map { GitHubAssetResolver.imageForYear(it) },
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
            images = listOf(1991, 1992, 1997, 2002).map { GitHubAssetResolver.imageForYear(it) },
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
            images = listOf(GitHubAssetResolver.imageForYear(2010)),
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
        mediaAssets = images.map { MediaAsset(it, AssetType.IMAGE) }
    )
}
