USE master
GO
if exists (select * from sys.databases where name like 'READINGBOOK_MANAGEMENT_SYSTEM')
	drop database READINGBOOK_MANAGEMENT_SYSTEM
Go

CREATE DATABASE READINGBOOK_MANAGEMENT_SYSTEM
GO

USE READINGBOOK_MANAGEMENT_SYSTEM
GO

CREATE TABLE Role (
	role_id		INT			PRIMARY KEY		NOT NULL,
	authority	VARCHAR(50)		
)
GO

CREATE TABLE BookCase (
	book_case_id		INT				PRIMARY KEY		IDENTITY(0,1),
	book_case_name		NVARCHAR(50)	NOT NULL	
)
GO

CREATE TABLE Users(
	id		INT		PRIMARY KEY		IDENTITY(1,1),
	user_name		NVARCHAR(50)	NOT NULL UNIQUE,
	password		varchar(64)		NOT NULL check(len(password) = 64),
	book_case_id	INT				UNIQUE	NOT NULL,
	role_id			INT				DEFAULT '2',
	FOREIGN KEY (book_case_id) REFERENCES BookCase(book_case_id),
	FOREIGN KEY (role_id)		REFERENCEs	Role(role_id)
)
GO

CREATE TABLE Book(
	book_id		INT PRIMARY KEY IDENTITY(1,1) NOT NULL,
	book_title	NVARCHAR(50)				  NOT NULL,
	author		NVARCHAR(50)				  NOT NULL,
	brief		NVARCHAR(1000)				  NOT NULL,
	publisher	NVARCHAR(50)				  NOT NULL,
	content		NVARCHAR(3000)				  NOT NULL,
	category	NVARCHAR(50)				  NOT NULL
)	
GO

CREATE TABLE Contain(
	book_case_id		INT			NOT NULL,
	book_id				INT			NOT NULL,
	create_date			DATE		DEFAULT (GETDATE()),
	FOREIGN KEY (book_case_id) REFERENCES BookCase(book_case_id),
	FOREIGN KEY (book_id)		REFERENCES	Book(book_id),
	PRIMARY KEY(book_case_id, book_id)
)
GO

INSERT INTO BookCase (book_case_name)
	VALUES	('All Books'), ('Book Case 1'), ('Book Case 2'), ('Book Case 3'), ('Book Case 4'), ('Book Case 5'), ('Book Case 6')
GO

INSERT INTO Role (role_id, authority)
	VALUES	(1,'Admin'), (2,'User')
GO

INSERT INTO Users (user_name,password,book_case_id)
	VALUES	('HuongNL6','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',1),
			('AnhHTT','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',2),
			('TungNS15','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',3),
			('ChangDTT','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',4),
			('HuongLT22','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',5)
GO
INSERT INTO Users (user_name,password,book_case_id,role_id)
	VALUES ('CuongVM14','8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92',0,1)
GO


INSERT INTO Book(book_title, author, brief, publisher, content, category)
	VALUES	('Charlotte Web','E.B.White','This is the story of a little girl named Fern who loved a little pig named Wilbur-and of dear friend of Wilbur Charlotte A. Cavatica, a beautiful large grey spider who lived with Wilbur in the barn. With the help ofTempleton, the rat who never did anything for anybody unless there was something in it for him, and by a wonderfully clever plan of her own, Charlotte saved the life of Wilbur, who by this time had grown up to be quite a pig. ', 'Fahasa','A minute later, Fern was seated on the floor in the comer of the kitchen with her infant between her knees, teaching it to suck from the bottle. The pig, although tiny, had a good appetite and caught on quickly. The school bus honked from the road. "Run!" commanded Mrs. Arable, taking the pig from Fern and slipping a doughnut into her hand. Avery grabbed his gun and another doughnut. The children ran out to the road and climbed into the bus. Fern took no notice of the others in the bus. She just sat and stared out of the window, thinking what a blissful world it was and how lucky she was to have entire charge of a pig. By the time the bus reached school, F em had named her pet, selecting the most beautiful name she could think of. ...','novel'),
			('The $100 Startup','Chris Guillebeau','In the first part of this summary, we’ll discuss Guillebeau’s three lessons; convergence, skill transformation, and the magic formula. Then we’ll move on to discuss adding value and following your passion before we dive into Guillebeau’s concept of the 1-page business plan, how to test your market, mission statements and launching. Finally, we’ll discuss making money and long-term plans.', 'Fahasa','Anyone wanting to take a leap towards working for themselves or working on a startup should read this book! The $100 Startup by Chris Guillebeau has two key themes: freedom and value. Freedom is what we’re all looking for, and value is the way to achieve it. The concept of having your own startup is the ultimate form of freedom according to Chris Guillebeau. He discusses different lessons on the road to beginning your own startup. With a focus on small ‘micro businesses,’ this book has plenty of tips and advice for every step of the journey...','novel'),
			('The Outsiders','S. E. Hinton','According to Wikipedia, The Outsiders is a coming-of-age novel by S. E. Hinton, first published in 1967 by Viking Press. Hinton was 15 when she started writing the novel, but did most of the work when she was sixteen and a junior in high school. Hinton was 18 when the book was published. ', 'Fahasa','WHEN I STEPPED OUT into the bright sunlight from the darkness of the movie house, I had only two things on my mind: Paul Newman and a ride home. I was wishing I looked like Paul Newman--- he looks tough and I do not--- but I guess my own looks are not so bad. I have light-brown, almost-red hair and greenish-gray eyes. I wish they were more gray, because I hate most guys that have green eyes, but I have to be content with what I have. My hair is longer than a lot of boys wear theirs, squared off in back and long at the front and sides, but I am a greaser and most of my neighborhood rarely bothers to get a haircut. Besides, I look better with long hair....','novel'),
			('Old Man and the Sea','Kindle Edition','The Old Man and the Sea tells the story of a battle between an aging, experienced fisherman, Santiago, and a large marlin. The story opens with Santiago having gone 84 days without catching a fish, and now being seen as "salao", the worst form of unluckiness.', 'Fahasa','The Old Man and the Sea contains many of the themes that preoccupied Hemingway as a writer and as a man. The routines of life in a Cuban fishing village are evoked in the opening pages with a characteristic economy of language. The stripped-down existence of the fisherman Santiago is crafted in a spare, elemental style that is as eloquently dismissive as a shrug of the old man’s powerful shoulders. With age and luck now against him, Santiago knows he must row out “beyond all people,” away from land and into the Gulf Stream, where one last drama would be played out, in an empty arena of sea and sky....','novel'),
			('The Giver','Lois Lowry','The giver is written from the point of view of Jonas, an eleven-year-old boy living in a futuristic society that has eliminated all pain, fear, war, and hatred. There is no prejudice, since everyone looks and acts basically the same, and there is very little competition. Everyone is unfailingly polite. The society has also eliminated choice: at age twelve every member of the community is assigned a job based on his or her abilities and interests. ', 'Fahasa','Jonas lives with his father, a Nurturer of new children, his mother, who works at the Department of Justice, and his seven-year-old sister Lily. At the beginning of the novel, he is apprehensive about the upcoming Ceremony of Twelve, when he will be given his official Assignment as a new adult member of the community. He does not have a distinct career preference, although he enjoys volunteering at a variety of different jobs. Though he is a well-behaved citizen and a good student, Jonas is different: he has pale eyes, while most people in his community have dark eyes, and he has unusual powers of perception. Sometimes objects “change” when he looks at them. He does not know it yet, but he alone in his community can perceive flashes of color; for everyone else, the world is as devoid of color as it is of pain, hunger, and inconvenience....','novel'),
			('The Power of Habit','  Charles Duhigg', 'In The Power of Habit, award-winning New York Times business reporter Charles Duhigg takes us to the thrilling edge of scientific discoveries that explain why habits exist and how they can be changed. With penetrating intelligence and an ability to distill vast amounts of information into engrossing narratives, Duhigg brings to life a whole new understanding of human nature and its potential for transformation','Fahasa','Along the way we learn why some people and companies struggle to change, despite years of trying, while others seem to remake themselves overnight. We visit laboratories where neuroscientists explore how habits work and where, exactly, they reside in our brains. ','novel'),
			('Never Split the Difference','Chris Voss','A former international hostage negotiator for the FBI offers a new, field-tested approach to high-stakes negotiations—whether in the boardroom or at home. After a stint policing the rough streets of Kansas City, Missouri, Chris Voss joined the FBI, where his career as a hostage negotiator brought him face-to-face with a range of criminals, including bank robbers and terrorists. Reaching the pinnacle of his profession, he became the FBI’s lead international kidnapping negotiator.','Fahasa','Never Split the Difference takes you inside the world of high-stakes negotiations and into Voss’s head, revealing the skills that helped him and his colleagues to succeed where it mattered most: saving lives. In this practical guide, he shares the nine effective principles—counter-intuitive tactics and strategies—you too can use to become more persuasive in both your professional and personal life. Life is a series of negotiations you should be prepared for: buying a car; negotiating a salary; buying a home; renegotiating rent; deliberating with your partner.','novel'),
			('The Intelligent Investor',' Benjamin Graham','More than one million hardcovers soldNow available for the first time in paperback! The Classic Text Annotated to Update Graham is Timeless Wisdom for Today is  Market Conditions The greatest investment advisor of the twentieth century, Benjamin Graham taught and inspired people worldwide. Graham is philosophy of value investing which shields investors from substantial error and teaches them to develop long-term strategies -- has made The Intelligent Investor the stock market bible ever since its original publication in 1949','Fahasa','Vital and indispensable, this HarperBusiness Essentials edition of The Intelligent Investor is the most important book you will ever read on how to reach your financial goals. ','novel'),
			('The Chilbury Ladies Choir',' Jennifer Ryan','The village of Chilbury in Kent is about to ring in some changes.This is a delightful novel of wartime gumption and village spirit that will make your heart sing out.Kent, 1940.In the idyllic village of Chilbury change is afoot. Hearts are breaking as sons and husbands leave to fight, and when the Vicar decides to close the choir until the men return, all seems lost.But coming together in song is just what the women of Chilbury need in these dark hours, and they are ready to sing','Fahasa','THE CHILBURY LADIES’ CHOIR explores how a village can endure the onslaught of war, how monumental history affects small lives and how survival is as much about friendship as it is about courage.','novel'),
			('That Month in Tuscany','Inglath Cooper','That Month in Tuscany . Ren Sawyer and Lizzy Harper live completely different lives. He is a rock star with a secret he can no longer live with. She’s a regular person whose husband stood her up for a long planned anniversary trip. On a flight across the Atlantic headed for Italy, a drunken pity party and untimely turbulence literally drop Lizzy into Ren is lap','Fahasa','Exploring the streets of Florence and the hills of Tuscany together - two people with seemingly nothing in common - changes them both forever. And what they find in each other is something that might just heal them both','novel'),
			('Fool Me Once ','Catherine Bybee','From Weekday Brides to First Wives, a dazzling series about four women and their alliance of newfound friendship, unexpected love, and second chances. Cynical divorce attorney Lori Cumberland lives by one motto: Love is grand, but divorce is a hundred grand. With one failed marriage under her own personal belt, Lori had fallen hard and early—and it is not something she plans on repeating','Fahasa','His charming smile and cocky attitude distracts Lori and lowers her guard, which is exactly what Reed desires.But what appears as a one-time-only flirtation may be a plot orchestrated by Reed. As he is  taking his investigation to a dangerous level, it is Lori who could end up in jeopardy. Reed has only one shot for Lori to grant him a second chance. But if he comes clean with her, he blows his cover. And that just might cost him the opportunity for an alliance of family…and of love','novel'),
			('Pete the Cat',' Eric Litwin','Do not miss the first and bestselling book in the beloved Pete the Cat series! Pete the Cat goes walking down the street wearing his brand-new white shoes. Along the way, his shoes change from white to red to blue to brown to WET as he steps in piles of strawberries, blueberries, and other big messes! But no matter what color his shoes are, Pete keeps movin and groovin and singing his song. because it is all good ','Fahasa','Pete the Cat I Love My White Shoes asks the reader questions about the colors of different foods and objects kids love to interact with the story. The fun never stops download the free groovin ','novel'),
			('The Start of Something Good','Jennifer Probst','An enriching story of family ties, broken hearts, and second chances from New York Times bestselling author Jennifer Probst. When Ethan Bishop returns to the Hudson Valley, his body and spirit are a little worse for wear. As a former Special Forces paratrooper, he saw his fair share of conflict, and he came home with wounds, inside and out. At his sisters B & B and farm, he can keep all his pain at a safe distance. But quiet time is not easy when a fiery woman explodes into his life. It is business not pleasure—that brings Manhattan PR agent Mia Thrush reluctantly to the farm. ','Fahasa','Everything about him is irritating from his lean muscles and piercing blue eyes to his scent of sweat and musk.But as the summer unfolds and temperatures rise, Ethan and Mia discover how much they have in common: their guarded histories, an uncontrollable desire, and a passion for the future that could heal two broken hearts. But will their pasts threaten their fragile chance at a brand new future','novel'),
			('A Walk in the Woods ',' Bill Bryson','The Appalachian Trail stretches from Georgia to Maine and covers some of the most breathtaking terrain in America–majestic mountains, silent forests, sparking lakes. If you are going to take a hike, it is probably the place to go. And Bill Bryson is surely the most entertaining guide you will find ','Fahasa','The Appalachian Trail stretches from Georgia to Maine and covers some of the most breathtaking terrain in America–majestic mountains, silent forests, sparking lakes. If you are going to take a hike, it is  probably the place to go. And Bill Bryson is surely the most entertaining guide you will find ','novel'),
			('Stranger in the Forest',' Eric Hansen','Eric Hansen was the first westerner ever to walk across the island of Borneo. Completely cut off from the outside world for seven months, he traveled nearly 1500 miles with small bands of nomadic hunters known as Penan. Beneath the rain forest canopy, they trekked through a hauntingly beautiful jungle where snakes and frogs fly, pigs climb trees, giant carnivorous plants eat mice, and mushrooms glow at night ','Fahasa','At once a modern classic of travel literature and a gripping adventure story, Stranger in the Forest provides a rare and intimate look at the vanishing way of life of one of the last surviving groups of rain forest dwellers. Hansen is absorbing, and often chilling, account of his exploits is tempered with the humor and humanity that prompted the Penan to take him into their world and to share their secrets','novel'),
			('Harry Potter and the Deathly Hallows ',' J.K. Rowling','Harry Potter is leaving Privet Drive for the last time. But as he climbs into the sidecar of Hagrid’s motorbike and they take to the skies, he knows Lord Voldemort and the Death Eaters will not be far behind','Fahasa','The protective charm that has kept him safe until now is broken. But the Dark Lord is breathing fear into everything he loves. And he knows he can not keep hiding. To stop Voldemort, Harry knows he must find the remaining Horcruxes and destroy them. He will have to face his enemy in one final battle','novel'),
			('Where would You Go, Bernadette','Maria Semple','Bernadette Fox has vanished. When her daughter Bee claims a family trip to Antarctica as a reward for perfect grades, Bernadette, a fiercely intelligent shut-in, throws herself into preparations for the trip. But worn down by years of trying to live the Seattle life she never wanted, Ms. Fox is on the brink of a meltdown','Fahasa','Bernadette Fox has vanished. When her daughter Bee claims a family trip to Antarctica as a reward for perfect grades, Bernadette, a fiercely intelligent shut in, throws herself into preparations for the trip. But worn down by years of trying to live the Seattle life she never wanted, Ms. Fox is on the brink of a meltdown.','novel'),
			('A Short History of Nearly Everything',' Bill Bryson','In Bryson is biggest book, he confronts his greatest challenge  to understand—and, if possible, answer—the oldest, biggest questions we have posed about the universe and ourselves. Taking as territory everything from the Big Bang to the rise of civilization, Bryson seeks to understand how we got from there being nothing at all to there being us ','Fahasa','A Short History of Nearly Everything is the record of this quest, and it is a sometimes profound, sometimes funny, and always supremely clear and entertaining adventure in the realms of human knowledge, as only Bill Bryson can render it. Science has never been more involving or entertaining','novel'),
			('Whiskey Chaser ',' Lucy Score','I am afraid my vagina might turn itself inside out if you try to give it another orgasm so soon. Scarlett Bodine Raised by her three overbearing brothers, Scarlett is a hell-raising tomboy with a tool belt. A tornado stirring up trouble everywhere she goes. Her favorite pastimes? Drinking any man under the table and two-stepping. But she has zero interest in love. Scarletts only being neighborly when she claims her sexy next-door neighbor as her new pet project ','Fahasa','The golden boy is now the black sheep relegated to Bootleg Springs, a tiny West Virginia town with two claims to fame  Moonshine and  The cold case disappearance of a teen girl. Devlin just wants to lick his wounds. But Scarlett has other ideas for his tongue… and the rest of him. She is determined to bring him back to life, even if getting him back on his feet means never seeing him again. But when an old mystery becomes new news, she will need his help to survive the scandal','novel'),
			('1000 Places to See Before You Die',' Patricia Schultz','Around the World, continent by continent, here is the best the world has to offer 1000 places guaranteed to give travelers the shivers. Sacred ruins, grand hotels, wildlife preserves, hilltop villages, snack shacks, castles, festivals, reefs, restaurants, cathedrals, hidden islands, opera houses, museums, and more. Each entry tells exactly why it is essential to visit. Then come the nuts and bolts: addresses, websites, phone and fax numbers, best times to visit. Stop dreaming and get going.','Fahasa',' Each entry lists exactly where to find the spot  Moorea is located 12 miles/19 km northwest of Tahiti 10 minutes by air, 1 hour by boat and when to go if you want to check out The Complete Fly Fisher hotel in Montana, May and Sept-Oct offer productive angling in a solitary setting. This is an excellent resource for the intrepid traveler','novel'),
			('Love & Gelato',' Jenna Evans Welch','I made the wrong choice. Lina is spending the summer in Tuscany, but she is not in the mood for Italy is famous sunshine and fairy-tale landscape. She is only there because it was her mother is dying wish that she get to know her father. But what kind of father isn not around for sixteen years?','Fahasa','All Lina wants to do is get back home. But then she is given a journal that her mom had kept when she lived in Italy. Suddenly Lina is uncovering a magical world of secret romances, art, and hidden bakeries. A world that inspires Lina, along with the ever-so-charming Ren, to follow in her mother is footsteps and unearth a secret that has been kept for far too long. It is a secret that will change everything she knew about her mother, her father—and even herself. People come to Italy for love and gelato, someone tells her, but sometimes they discover much more','novel'),
			('One Summer in Paris','One Summer in Paris','Morgan is a masterful storyteller, and readers will be fully immersed in this realistic but magical summer in Paris. Packed full of love, loss, heartbreak, and hope, this may just be Morgan is best book yet. For fans of Jojo Moyes, Taylor Jenkins Reid, and Stacey Ballis -Booklist Review on One Summer in Paris USA TODAY bestselling author Sarah Morgan returns with this heartwarming novel about the power of friendship, love and what happens when an ending is just the beginning… To celebrate their twenty-fifth wedding anniversary, Grace has planned the surprise of a lifetime for her husband a romantic getaway to Paris','Fahasa','A job in a bookshop is her ticket to freedom, but with no money and no knowledge of the French language, suddenly a summer spent wandering the cobbled streets alone seems much more like until she meets Grace, and everything changes. Grace can not believe how daring Audrey is. Audrey can not believe how cautious newly single Grace is. Living in neighboring apartments above the bookshop, this unlikely pair offer each other just what they have both been missing. They came to Paris to find themselves, but finding this unbreakable friendship might be the best thing that is ever happened to them','novel'),
			('Big Little Lies',' Liane Moriarty','From the author of Truly Madly Guilty and The Husbands Secret comes a novel about the dangerous little lies we tell ourselves just to survive. A murder... A tragic accident... Or just parents behaving badly? What s indisputable is that someone is dead. Madeline is a force to be reckoned with. She s funny, biting, and passionate; she remembers everything and forgives no one. Celeste is the kind of beautiful woman who makes the world stop and stare but she is paying a price for the illusion of perfection.','Fahasa','New to town, single mum Jane is so young that another mother mistakes her for a nanny. She comes with a mysterious past and a sadness beyond her years. These three women are at different crossroads, but they will all wind up in the same shocking place. Big Little Lies is a brilliant take on ex-husbands and second wives, mothers and daughters, schoolyard scandal, and the little lies that can turn lethal.','novel'),
			('I wll Never Tell',' Catherine McKenzie','What happened to Amanda Holmes? Twenty years ago, she washed up on shore in a rowboat with a gash to the head after an overnight at Camp Macaw. No one was ever charged with a crime. Now, the MacAllister children are all grown up. After their parents die suddenly, they return to Camp to read the will and decide what to do with the prime real estate it is sitting on. Ryan, the oldest, wants to sell','Fahasa','What happened to Amanda Holmes? Twenty years ago, she washed up on shore in a rowboat with a gash to the head after an overnight at Camp Macaw. No one was ever charged with a crime. Now, the MacAllister children are all grown up. After their parents die suddenly, they return to Camp to read the will and decide what to do with the prime real estate it is sitting on. Ryan, the oldest, wants to sell','novel'),
			('And So It Begins',' Rachel Abbott','So this is how it ends. It is clear to me now: one of us has to die. Mark and Evie had a whirlwind romance. Evie brought Mark back to life after the sudden death of his first wife. Cleo, Mark is sister, knows she should be happy for him. But Cleo does not trust Evie... When Evie starts having accidents at home, her friends grow concerned. Could Mark be causing her injuries? Called out to their cliff-top house one night, Sergeant Stephanie King finds two bodies entangled on blood-drenched sheets. ','Fahasa','Where does murder begin? When the knife is raised to strike, or before, at the first thought of violence? As Evie stands trial, the jury is forced to consider - is there ever a proper defence for murder? And So It Begins is a darkly compulsive psychological thriller with all the hallmarks of a Rachel Abbott bestseller - a provocative dilemma, richly-layered mystery, knife-edge tension, and brilliant characterization. Praise for Rachel Abbott A properly addictive, leave-the-light-on thriller Red Magazine Masterly and compelling. I could not put it down until its heart-stopping conclusion Robert Bryndza Unbearably tense, with a killer twist Good Housekeeping','novel'),
			('A Study in Scarlet ',' Arthur Conan Doyle','There is a scarlet thread of murder running through the colourless skein of life, and our duty is to unravel it, and isolate it, and expose every inch of it. From the moment Dr John Watson takes lodgings in Baker Street with the consulting detective Sherlock Holmes, he becomes intimately acquainted with the bloody violence and frightening ingenuity of the criminal mind','Fahasa','In A Study in Scarlet , Holmes and Watson is first mystery, the pair are summoned to a south London house where they find a dead man whose contorted face is a twisted mask of horror. The body is unmarked by violence but on the wall a mysterious word has been written in blood. The police are baffled by the crime and its circumstances. But when Sherlock Holmes applies his brilliantly logical mind to the problem he uncovers a tragic tale of love and deadly revenge ','novel'),
			('Murder at the Vicarage',' Agatha Christie','Murder at the Vicarage marks the debut of Agatha Christie is unflappable and much beloved female detective, Miss Jane Marple. With her gift for sniffing out the malevolent side of human nature, Miss Marple is led on her first case to a crime scene at the local vicarage ','Fahasa','Colonel Protheroe, the magistrate whom everyone in town hates, has been shot through the head. No one heard the shot. There are no leads. Yet, everyone surrounding the vicarage seems to have a reason to want the Colonel dead. It is a race against the clock as Miss Marple sets out on the twisted trail of the mysterious killer without so much as a bit of help from the local police','novel'),
			('A Short History of Nearly Everything','Bill Bryson','In Bryson is biggest book, he confronts his greatest challenge: to understand and, if possible, answer the oldest, biggest questions we have posed about the universe and ourselves. Taking as territory everything from the Big Bang to the rise of civilization, Bryson seeks to understand how we got from there being nothing at all to there being us. To that end, he has attached himself to a host of the world is most advanced (and often obsessed) archaeologists, anthropologists, and mathematicians, travelling to their offices, laboratories, and field camps ','Fahasa','In Bryson is biggest book, he confronts his greatest challenge to understand and, if possible, answer the oldest, biggest questions we have posed about the universe and ourselves. Taking as territory everything from the Big Bang to the rise of civilization, Bryson seeks to understand how we got from there being nothing at all to there being us. To that end, he has attached himself to a host of the world is most advanced and often obsessed archaeologists, anthropologists, and mathematicians, travelling to their offices, laboratories, and field camps ','novel'),
			('Surely You are Joking, Mr. Feynman',' Richard P. Feynman','A New York Times bestseller the outrageous exploits of one of this century is greatest scientific minds and a legendary American original.Richard Feynman, winner of the Nobel Prize in physics, thrived on outrageous adventures','Fahasa','A New York Times bestseller—the outrageous exploits of one of this century is greatest scientific minds and a legendary American original.Richard Feynman, winner of the Nobel Prize in physics, thrived on outrageous adventures','novel'),
			('The Gene An Intimate History','Siddhartha Mukherjee','From the Pulitzer Prize-winning, bestselling author of The Emperor of All Maladies a magnificent history of the gene and a response to the defining question of the future: What becomes of being human when we learn to read and write our own genetic information? Siddhartha Mukherjee has a written a biography of the gene as deft, brilliant, and illuminating as his extraordinarily successful biography of cancer','Fahasa','An extraordinary achievement.Riveting, revelatory, and magisterial history of a scientific idea coming to life, and an essential preparation for the moral complexity introduced by our ability to create or write the human genome, The Gene is a must-read for everyone concerned about the definition and future of humanity. This is the most crucial science of our time, intimately explained by a master','novel'),
			('The Fabric of the Cosmos',' Brian Greene','From Brian Greene, one of the world is leading physicists and author the Pulitzer Prize finalist The Elegant Universe, comes a grand tour of the universe that makes us look at reality in a completely different way.Space and time form the very fabric of the cosmos. Yet they remain among the most mysterious of concepts. Is space an entity? Why does time have a direction? Could the universe exist without space and time ','Fahasa','From Brian Greene, one of the world is leading physicists and author the Pulitzer Prize finalist The Elegant Universe, comes a grand tour of the universe that makes us look at reality in a completely different way.Space and time form the very fabric of the cosmos. Yet they remain among the most mysterious of concepts. Is space an entity? Why does time have a direction? Could the universe exist without space and time? ','novel')
GO

INSERT INTO Contain(book_case_id,book_id)
	VALUES	(1,1),
			(2,2),
			(3,3),
			(4,4),
			(5,5)
GO

CREATE PROCEDURE sp_checkExists @username NVARCHAR(50)
as
	if exists (select * from Users where user_name like @userName) SELECT 1
	else 
		SELECT 0
GO

CREATE PROCEDURE sp_insertUser @user_name NVARCHAR(50), @password	varchar(64)
AS
	if not exists (select * from BookCase where book_case_name like ('Bookcase of ' + @user_name))
		INSERT INTO BookCase (book_case_name) VALUES ('Bookcase of ' + @user_name)

	INSERT Into Users (user_name, password, book_case_id) 
	VALUES (@user_name, @password, (select book_case_id from BookCase WHERE book_case_name like ('Bookcase of ' + @user_name) ))
GO

CREATE PROCEDURE sp_getuser @user_name NVARCHAR(50)
AS
	SELECT * FROM Users WHERE user_name = @user_name
GO

CREATE PROCEDURE sp_getAllBooks 
AS
SELECT * FROM Book 
GO

CREATE PROCEDURE sp_getBookCase @book_case_id INT
AS
	select * from BookCase 
	WHERE book_case_id = @book_case_id
GO

CREATE PROCEDURE sp_insertBookCase @book_case_name NVARCHAR(50)
AS
	Insert into BookCase VALUEs (@book_case_name)
GO


CREATE PROCEDURE sp_getBookInBookCase @book_case_id INT
AS
	select * from Book 
	WHERE book_id in (
		select book_id from Contain 
		WHERE book_case_id = @book_case_id
	)
GO

CREATE PROCEDURE sp_inserBookToBookCase @book_case_id INT, @book_id INT
AS
	insert into Contain(book_case_id, book_id) 
	VALUES(@book_case_id, @book_id)
GO

CREATE PROCEDURE sp_deleteBookFromBookCase @book_case_id INT, @book_id INT
AS
	DELETE from Contain 
	WHERE book_case_id = @book_case_id and book_id = @book_id
GO

CREATE PROCEDURE sp_insertBook @book_title NVARCHAR(50),@author NVARCHAR(50), @brief NVARCHAR(1000),@publisher	NVARCHAR(50),@content NVARCHAR(3000),@category	NVARCHAR(50)
AS
	INSERT into Book (book_title, author, brief, publisher, content, category) 
	VALUES (@book_title, @author, @brief, @publisher, @content, @category)
go

CREATE PROCEDURE sp_updateBook @book_id int, @book_title	NVARCHAR(50),@author NVARCHAR(50), @brief NVARCHAR(1000),@publisher	NVARCHAR(50),@content NVARCHAR(3000),@category	NVARCHAR(50)
AS
	UPDATE Book
	set
		book_title = @book_title, 
		author = @author, 
		brief = @brief,
		publisher = @publisher, 
		content = @content, 
		category =  @category
	WHERE 
		book_id = @book_id
go

CREATE PROCEDURE sp_deleteBook @book_id int
AS
	DELETE from Contain WHERE book_id = @book_id
	Delete from Book where book_id = @book_id
GO

CREATE PROCEDURE sp_delAllBookInCase @book_case_id int
AS
	DELETE from Contain WHERE book_case_id = @book_case_id
GO



