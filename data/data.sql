USE [master]
GO
/****** Object:  Database [Bai01]    Script Date: 30/09/2024 22:01:46 ******/
CREATE DATABASE [Bai01]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Bai02', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Bai02.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Bai02_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.SQLEXPRESS\MSSQL\DATA\Bai02_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [Bai01] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Bai01].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Bai01] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Bai01] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Bai01] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Bai01] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Bai01] SET ARITHABORT OFF 
GO
ALTER DATABASE [Bai01] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Bai01] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Bai01] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Bai01] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Bai01] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Bai01] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Bai01] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Bai01] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Bai01] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Bai01] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Bai01] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Bai01] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Bai01] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Bai01] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Bai01] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Bai01] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Bai01] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Bai01] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Bai01] SET  MULTI_USER 
GO
ALTER DATABASE [Bai01] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Bai01] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Bai01] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Bai01] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Bai01] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Bai01] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [Bai01] SET QUERY_STORE = ON
GO
ALTER DATABASE [Bai01] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [Bai01]
GO
/****** Object:  Table [dbo].[users]    Script Date: 30/09/2024 22:01:46 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[users](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[birthday] [date] NULL,
	[email] [varchar](255) NULL,
	[firstName] [varchar](50) NOT NULL,
	[gender] [varchar](255) NULL,
	[lastName] [varchar](50) NOT NULL,
	[password] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[users] ON 

INSERT [dbo].[users] ([id], [birthday], [email], [firstName], [gender], [lastName], [password]) VALUES (1, CAST(N'2000-10-10' AS Date), N'john@gmail.com', N'John1111', N'Male', N'22222222', N'123')
INSERT [dbo].[users] ([id], [birthday], [email], [firstName], [gender], [lastName], [password]) VALUES (2, CAST(N'2000-10-10' AS Date), N'smith@gmail.com', N'Smith111', N'Male', N'22222222', N'abc')
INSERT [dbo].[users] ([id], [birthday], [email], [firstName], [gender], [lastName], [password]) VALUES (3, CAST(N'1999-09-01' AS Date), N'david@gmail.com', N'David111', N'Male', N'22222222', N'jehfhu')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
USE [master]
GO
ALTER DATABASE [Bai01] SET  READ_WRITE 
GO
