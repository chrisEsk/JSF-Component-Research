USE [master]
GO

/****** Object:  Database [BDAdmin]    Script Date: 3/16/2014 10:49:33 PM ******/
CREATE DATABASE [BDAdmin]
GO

USE [BDAdmin]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 3/16/2014 10:49:33 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tblUser](
	[usuario] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tbl_User] PRIMARY KEY CLUSTERED 
(
	[usuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[tblUser] ([usuario], [password]) VALUES (N'Carlos', N'krlosFer123')
GO
INSERT [dbo].[tblUser] ([usuario], [password]) VALUES (N'Yuli', N'yuli0192')
GO
USE [master]
GO
ALTER DATABASE [BDAdmin] SET  READ_WRITE 
GO
