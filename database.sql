USE [PolicyMotor]
GO
/****** Object:  Table [dbo].[Client]    Script Date: 03/15/2021 6:17:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Client](
	[clientId] [varchar](8) NOT NULL,
	[firstName] [varchar](60) NULL,
	[lastName] [varchar](60) NULL,
	[ClientAddress] [varchar](120) NULL,
	[maritalStatus] [varchar](3) NULL,
	[gender] [varchar](3) NULL,
	[country] [varchar](3) NULL,
	[dateOfBirth] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[clientId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Motor]    Script Date: 03/15/2021 6:17:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Motor](
	[vehicleRegistrationNo] [varchar](30) NOT NULL,
	[chassisNo] [varchar](30) NOT NULL,
	[engineNo] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[vehicleRegistrationNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[chassisNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[engineNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Policy]    Script Date: 03/15/2021 6:17:07 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Policy](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[policyNo] [varchar](8) NOT NULL,
	[inceptionDate] [datetime] NULL,
	[expiryDate] [datetime] NULL,
	[renewDate] [datetime] NULL,
	[policyOwner] [varchar](8) NULL,
	[sumInsured] [numeric](17, 2) NULL,
	[rate] [numeric](5, 2) NULL,
	[statusPolicy] [varchar](30) NULL,
	[annualPremium] [numeric](17, 2) NULL,
	[postedPremium] [numeric](17, 2) NULL,
	[billingCurrency] [varchar](30) NOT NULL,
	[vehicleRegistrationNo] [varchar](30) NOT NULL,
	[chassisNo] [varchar](30) NOT NULL,
	[engineNo] [varchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[policyNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[chassisNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[engineNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
ALTER TABLE [dbo].[Policy] ADD  DEFAULT ('VND') FOR [billingCurrency]
GO
ALTER TABLE [dbo].[Policy]  WITH CHECK ADD  CONSTRAINT [FK_Policy_Owner] FOREIGN KEY([policyOwner])
REFERENCES [dbo].[Client] ([clientId])
GO
ALTER TABLE [dbo].[Policy] CHECK CONSTRAINT [FK_Policy_Owner]
GO
